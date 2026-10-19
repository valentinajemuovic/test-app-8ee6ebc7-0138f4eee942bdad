package com.valentinajemuovic.skytravel.systemtest.legacy.mod08.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod08.base.BaseScenarioDslTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

class SkyTravelSmokeTest extends BaseScenarioDslTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldBeAbleToGoToSkyTravel() {
        scenario.assume().skyTravel().shouldBeRunning();
    }
}

