package com.valentinajemuovic.skytravel.systemtest.legacy.mod04.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod04.base.BaseClientTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SkyTravelUiSmokeTest extends BaseClientTest {
    @BeforeEach
    void setUp() {
        setUpSkyTravelUiClient();
    }

    @Test
    void shouldBeAbleToGoToSkyTravel() {
        skyTravelUiClient.openHomePage();
        assertTrue(skyTravelUiClient.isPageLoaded());
    }
}


