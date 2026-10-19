package com.valentinajemuovic.skytravel.systemtest.latest.acceptance;

import com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base.BaseAcceptanceTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

import static com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ScenarioDefaults.DEFAULT_ORDER_NUMBER;

class BrowseOrderHistoryPositiveTest extends BaseAcceptanceTest {
    @TestTemplate
    @Channel(ChannelType.API)
    void customerShouldSeeOwnOrderInHistory() {
        scenario
                .given().order()
                    .placedByCustomer()
                .and().loggedInAsCustomer()
                .when().browseOrderHistory()
                .then().shouldSucceed()
                    .orderHistory()
                        .containsOrder(DEFAULT_ORDER_NUMBER);
    }

    @TestTemplate
    @Channel(ChannelType.API)
    void adminShouldSeeCustomerOrderInHistory() {
        scenario
                .given().order()
                    .placedByCustomer()
                .and().loggedInAsAdmin()
                .when().browseOrderHistory()
                .then().shouldSucceed()
                    .orderHistory()
                        .containsOrder(DEFAULT_ORDER_NUMBER);
    }

    @TestTemplate
    @Channel(ChannelType.API)
    void adminShouldSeeAnotherCustomersOrderInHistory() {
        scenario
                .given().order()
                    .placedByCustomer("B")
                .and().loggedInAsAdmin()
                .when().browseOrderHistory()
                .then().shouldSucceed()
                    .orderHistory()
                        .containsOrder(DEFAULT_ORDER_NUMBER);
    }
}
