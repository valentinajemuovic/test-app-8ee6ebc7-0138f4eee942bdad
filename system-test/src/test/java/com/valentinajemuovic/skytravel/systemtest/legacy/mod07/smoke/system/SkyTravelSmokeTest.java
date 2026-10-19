package com.valentinajemuovic.skytravel.systemtest.legacy.mod07.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod07.base.BaseUseCaseDslTest;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

class SkyTravelSmokeTest extends BaseUseCaseDslTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldBeAbleToGoToSkyTravel() {
        app.skyTravel().goToSkyTravel()
                .execute()
                .shouldSucceed();
    }
}

