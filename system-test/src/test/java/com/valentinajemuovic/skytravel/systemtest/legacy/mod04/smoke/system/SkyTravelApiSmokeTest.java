package com.valentinajemuovic.skytravel.systemtest.legacy.mod04.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod04.base.BaseClientTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.valentinajemuovic.skytravel.testkit.common.ResultAssert.assertThatResult;

class SkyTravelApiSmokeTest extends BaseClientTest {
    @BeforeEach
    void setUp() {
        setUpSkyTravelApiClient();
    }

    @Test
    void shouldBeAbleToGoToSkyTravel() {
        var result = skyTravelApiClient.health().checkHealth();
        assertThatResult(result).isSuccess();
    }
}


