package com.valentinajemuovic.skytravel.systemtest.legacy.mod03.e2e;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.valentinajemuovic.skytravel.systemtest.legacy.mod03.e2e.base.BaseE2eTest;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.valentinajemuovic.skytravel.systemtest.commons.constants.Defaults.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlaceOrderPositiveUiTest extends BaseE2eTest {
    @Override
    protected void setSkyTravelClient() {
        setUpSkyTravelBrowser();
    }

    @Test
    void shouldPlaceOrderForValidInput() throws Exception {
        var sku = SKU + "-" + UUID.randomUUID().toString().substring(0, 8);
        var createProductJson = """
                {
                    "id": "%s",
                    "title": "Test Product",
                    "description": "Test Description",
                    "category": "Test Category",
                    "brand": "Test Brand",
                    "price": "20.00"
                }
                """.formatted(sku);

        var createProductUri = URI.create(getErpBaseUrl() + "/api/products");
        var createProductRequest = HttpRequest.newBuilder()
                .uri(createProductUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(createProductJson))
                .build();

        var createProductResponse = erpHttpClient.send(createProductRequest, HttpResponse.BodyHandlers.ofString());
        assertThat(createProductResponse.statusCode()).isEqualTo(201);

        skyTravelUiPage.navigate(getSkyTravelUiBaseUrl());
        loginToSkyTravelUiIfRequired();
        skyTravelUiPage.locator("a[href='/new-order']").click();

        skyTravelUiPage.locator("[aria-label=\"SKU\"]").fill(sku);
        skyTravelUiPage.locator("[aria-label=\"Quantity\"]").fill("5");
        skyTravelUiPage.locator("[aria-label=\"Country\"]").fill(COUNTRY);
        skyTravelUiPage.locator("[aria-label=\"Place Order\"]").click();

        var successMessageText = skyTravelUiPage.locator("[role='alert'][data-notification-id]").textContent();
        var pattern = Pattern.compile("Success! Order has been created with Order Number ([\\w-]+)");
        var matcher = pattern.matcher(successMessageText);
        assertThat(matcher.find()).isTrue();
        var orderNumber = matcher.group(1);
        assertThat(orderNumber).startsWith("ORD-");

        skyTravelUiPage.navigate(getSkyTravelUiBaseUrl());
        skyTravelUiPage.locator("a[href='/order-history']").click();
        skyTravelUiPage.locator("[aria-label='Order Number']").fill(orderNumber);
        skyTravelUiPage.locator("[aria-label='Refresh Order List']").click();

        var rowSelector = String.format("//tr[contains(., '%s')]", orderNumber);
        skyTravelUiPage.locator(rowSelector).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(skyTravelUiPage.locator(rowSelector).isVisible()).isTrue();

        var viewDetailsSelector = String.format("%s//a[contains(text(), 'View Details')]", rowSelector);
        skyTravelUiPage.locator(viewDetailsSelector).click();

        skyTravelUiPage.locator("[aria-label='Display Order Number']")
                .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        assertThat(skyTravelUiPage.locator("[aria-label='Display Order Number']").textContent()).isEqualTo(orderNumber);
        assertThat(skyTravelUiPage.locator("[aria-label='Display SKU']").textContent()).isEqualTo(sku);
        assertThat(Integer.parseInt(skyTravelUiPage.locator("[aria-label='Display Quantity']").textContent())).isEqualTo(5);

        var unitPriceText = skyTravelUiPage.locator("[aria-label='Display Unit Price']").textContent().replace("$", "");
        assertThat(Double.parseDouble(unitPriceText)).isEqualTo(20.00);

        var basePriceText = skyTravelUiPage.locator("[aria-label='Display Base Price']").textContent().replace("$", "");
        assertThat(Double.parseDouble(basePriceText)).isEqualTo(100.00);

        var totalPriceText = skyTravelUiPage.locator("[aria-label='Display Total Price']").textContent().replace("$", "");
        assertThat(Double.parseDouble(totalPriceText)).isGreaterThan(0.0);

        assertThat(skyTravelUiPage.locator("[aria-label='Display Status']").textContent()).isEqualTo("PLACED");
    }
}
