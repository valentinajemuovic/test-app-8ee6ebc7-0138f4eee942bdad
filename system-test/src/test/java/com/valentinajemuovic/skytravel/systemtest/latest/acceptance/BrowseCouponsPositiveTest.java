package com.valentinajemuovic.skytravel.systemtest.latest.acceptance;

import com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base.BaseAcceptanceTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

class BrowseCouponsPositiveTest extends BaseAcceptanceTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldBeAbleToBrowseCoupons() {
        scenario
                .when().browseCoupons()
                .then().shouldSucceed();
    }
}
