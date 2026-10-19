package com.valentinajemuovic.skytravel.systemtest.legacy.mod04.e2e;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod04.e2e.base.BaseE2eTest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PlaceOrderRequest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.valentinajemuovic.skytravel.testkit.common.ResultAssert.assertThatResult;
import static com.valentinajemuovic.skytravel.systemtest.commons.constants.Defaults.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlaceOrderNegativeApiTest extends BaseE2eTest {
    @Override
    protected void setSkyTravelClient() {
        setUpSkyTravelApiClient();
    }

    @Test
    void shouldRejectOrderWithNonIntegerQuantity() {
        var placeOrderRequest = PlaceOrderRequest.builder()
                .sku(SKU + "-" + UUID.randomUUID().toString().substring(0, 8))
                .quantity("invalid-quantity")
                .country(COUNTRY)
                .build();

        var placeOrderResult = skyTravelApiClient.orders().placeOrder(placeOrderRequest);

        assertThatResult(placeOrderResult).isFailure();
        var error = placeOrderResult.getError();
        assertThat(error.getDetail()).isEqualTo("The request contains one or more validation errors");
        assertThat(error.getErrors()).anySatisfy(field -> {
            assertThat(field.getField()).isEqualTo("quantity");
            assertThat(field.getMessage()).isEqualTo("Quantity must be an integer");
        });
    }
}
