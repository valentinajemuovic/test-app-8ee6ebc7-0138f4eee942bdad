package com.valentinajemuovic.skytravel.systemtest.legacy.mod05.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod05.base.BaseDriverTest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.GoToSkyTravelRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.valentinajemuovic.skytravel.testkit.common.ResultAssert.assertThatResult;

public abstract class SkyTravelBaseSmokeTest extends BaseDriverTest {
    @BeforeEach
    void setUp() {
        setSkyTravelDriver();
    }

    protected abstract void setSkyTravelDriver();

    @Test
    void shouldBeAbleToGoToSkyTravel() {
        var result = skyTravelDriver.goToSkyTravel(GoToSkyTravelRequest.builder().build());
        assertThatResult(result).isSuccess();
    }
}

