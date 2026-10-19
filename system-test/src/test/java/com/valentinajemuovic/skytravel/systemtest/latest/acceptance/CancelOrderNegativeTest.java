package com.valentinajemuovic.skytravel.systemtest.latest.acceptance;

import com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base.BaseAcceptanceTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.common.domain.OrderStatus;
import com.optivem.testing.Channel;
import com.optivem.testing.DataSource;
import org.junit.jupiter.api.TestTemplate;

import static com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ScenarioDefaults.DEFAULT_ORDER_NUMBER;

class CancelOrderNegativeTest extends BaseAcceptanceTest {
    @TestTemplate
    @Channel({ChannelType.API})
    @DataSource({"NON-EXISTENT-ORDER-99999", "Order NON-EXISTENT-ORDER-99999 does not exist."})
    @DataSource({"NON-EXISTENT-ORDER-88888", "Order NON-EXISTENT-ORDER-88888 does not exist."})
    @DataSource({"NON-EXISTENT-ORDER-77777", "Order NON-EXISTENT-ORDER-77777 does not exist."})
    void shouldNotCancelNonExistentOrder(String orderNumber, String expectedErrorMessage) {
        scenario
                .when().cancelOrder()
                    .withOrderNumber(orderNumber)
                .then().shouldFail()
                    .errorMessage(expectedErrorMessage);
    }

    @TestTemplate
    @Channel({ChannelType.API})
    void shouldNotCancelAlreadyCancelledOrder() {
        scenario
                .given().order()
                    .withStatus(OrderStatus.CANCELLED)
                .when().cancelOrder()
                .then().shouldFail()
                    .errorMessage("Order has already been cancelled");
    }

    @TestTemplate
    @Channel({ChannelType.API})
    void cannotCancelNonExistentOrder() {
        scenario
                .when().cancelOrder()
                    .withOrderNumber("non-existent-order-12345")
                .then().shouldFail()
                    .errorMessage("Order non-existent-order-12345 does not exist.");
    }

    @TestTemplate
    @Channel({ChannelType.API})
    void customerShouldNotBeAbleToCancelAnotherCustomersOrder() {
        scenario
                .given().order()
                    .placedByCustomer("B")
                .and().loggedInAsCustomer("A")
                .when().cancelOrder()
                .then().shouldFail()
                    .errorMessage("Order " + DEFAULT_ORDER_NUMBER + " does not exist.");
    }
}
