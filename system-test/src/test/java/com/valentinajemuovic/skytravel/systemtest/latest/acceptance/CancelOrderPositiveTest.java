package com.valentinajemuovic.skytravel.systemtest.latest.acceptance;

import com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base.BaseAcceptanceTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.common.domain.OrderStatus;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

class CancelOrderPositiveTest extends BaseAcceptanceTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldHaveCancelledStatusWhenCancelled() {
        scenario
                .given().order()
                .when().cancelOrder()
                .then().shouldSucceed()
                .and().order()
                    .hasStatus(OrderStatus.CANCELLED);
    }

    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void adminShouldBeAbleToCancelCustomerOrder() {
        scenario
                .given().order()
                    .placedByCustomer()
                .and().loggedInAsAdmin()
                .when().cancelOrder()
                .then().shouldSucceed()
                .and().order()
                    .hasStatus(OrderStatus.CANCELLED);
    }
}
