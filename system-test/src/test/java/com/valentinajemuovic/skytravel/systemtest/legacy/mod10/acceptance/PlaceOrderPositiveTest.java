package com.valentinajemuovic.skytravel.systemtest.legacy.mod10.acceptance;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod10.acceptance.base.BaseAcceptanceTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.common.domain.OrderStatus;
import com.optivem.testing.Channel;

import org.junit.jupiter.api.TestTemplate;

class PlaceOrderPositiveTest extends BaseAcceptanceTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void orderNumberShouldStartWithORD() {
        scenario
                .when().placeOrder()
                .then().shouldSucceed()
                .and().order()
                    .hasOrderNumberPrefix("ORD-");
    }

    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void orderStatusShouldBePlacedAfterPlacingOrder() {
        scenario
                .when().placeOrder()
                .then().shouldSucceed()
                .and().order()
                    .hasStatus(OrderStatus.PLACED);
    }
}
