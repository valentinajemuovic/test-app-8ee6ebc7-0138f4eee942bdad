package com.valentinajemuovic.skytravel.systemtest.legacy.mod06.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod06.base.BaseChannelDriverTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.GoToSkyTravelRequest;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

import static com.valentinajemuovic.skytravel.testkit.common.ResultAssert.assertThatResult;

class SkyTravelSmokeTest extends BaseChannelDriverTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldBeAbleToGoToSkyTravel() {
        var result = skyTravelDriver.goToSkyTravel(GoToSkyTravelRequest.builder().build());
        assertThatResult(result).isSuccess();
    }
}

