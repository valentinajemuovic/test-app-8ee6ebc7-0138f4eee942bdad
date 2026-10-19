package com.valentinajemuovic.skytravel.systemtest.legacy.mod07.e2e;

import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.common.domain.OrderStatus;
import com.valentinajemuovic.skytravel.systemtest.legacy.mod07.e2e.base.BaseE2eTest;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

import static com.valentinajemuovic.skytravel.systemtest.commons.constants.Defaults.*;

class PlaceOrderPositiveTest extends BaseE2eTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldPlaceOrderForValidInput() {
        app.erp().returnsProduct().sku(SKU).unitPrice(20.00).execute()
                .shouldSucceed();

        app.skyTravel().placeOrder().orderNumber(ORDER_NUMBER).sku(SKU).quantity(5).country(COUNTRY).execute()
                .shouldSucceed()
                .orderNumber(ORDER_NUMBER)
                .orderNumberStartsWith("ORD-");

        app.skyTravel().viewOrder().orderNumber(ORDER_NUMBER).execute()
                .shouldSucceed()
                .orderNumber(ORDER_NUMBER)
                .sku(SKU)
                .quantity(5)
                .unitPrice(20.00)
                .status(OrderStatus.PLACED)
                .totalPriceGreaterThanZero();
    }
}
