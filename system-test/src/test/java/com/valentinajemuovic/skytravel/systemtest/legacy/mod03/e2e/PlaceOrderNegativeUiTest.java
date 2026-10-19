package com.valentinajemuovic.skytravel.systemtest.legacy.mod03.e2e;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod03.e2e.base.BaseE2eTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.valentinajemuovic.skytravel.systemtest.commons.constants.Defaults.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlaceOrderNegativeUiTest extends BaseE2eTest {
    @Override
    protected void setSkyTravelClient() {
        setUpSkyTravelBrowser();
    }

    @Test
    void shouldRejectOrderWithNonIntegerQuantity() {
        skyTravelUiPage.navigate(getSkyTravelUiBaseUrl());
        loginToSkyTravelUiIfRequired();
        skyTravelUiPage.locator("a[href='/new-order']").click();

        skyTravelUiPage.locator("[aria-label=\"SKU\"]").fill(SKU + "-" + UUID.randomUUID().toString().substring(0, 8));
        skyTravelUiPage.locator("[aria-label=\"Quantity\"]").fill("invalid-quantity");
        skyTravelUiPage.locator("[aria-label=\"Place Order\"]").click();

        var errorAlert = skyTravelUiPage.locator("[role='alert'][data-notification-id]");
        errorAlert.waitFor();
        assertThat(errorAlert.isVisible()).isTrue();
        var errorText = errorAlert.textContent();
        assertThat(errorText)
                .contains("The request contains one or more validation errors")
                .contains("quantity")
                .contains("Quantity must be an integer");
    }
}
