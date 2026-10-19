package com.valentinajemuovic.skytravel.systemtest.latest.acceptance;

import com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base.BaseAcceptanceTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

import static com.valentinajemuovic.skytravel.systemtest.commons.constants.ErrorMessages.PERMISSION_DENIED;

class BrowseCouponsNegativeTest extends BaseAcceptanceTest {
    @TestTemplate
    @Channel(ChannelType.API)
    void customerShouldNotBeAbleToBrowseCoupons() {
        scenario
                .given().loggedInAsCustomer()
                .when().browseCoupons()
                .then().shouldFail()
                    .errorMessage(PERMISSION_DENIED);
    }
}
