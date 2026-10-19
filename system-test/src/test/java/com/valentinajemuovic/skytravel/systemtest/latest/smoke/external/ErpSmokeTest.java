package com.valentinajemuovic.skytravel.systemtest.latest.smoke.external;

import com.valentinajemuovic.skytravel.systemtest.latest.base.BaseScenarioDslTest;
import org.junit.jupiter.api.Test;

class ErpSmokeTest extends BaseScenarioDslTest {
    @Test
    void shouldBeAbleToGoToErp() {
        scenario.assume().erp().shouldBeRunning();
    }
}