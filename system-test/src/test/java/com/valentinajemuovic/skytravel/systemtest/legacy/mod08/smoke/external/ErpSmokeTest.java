package com.valentinajemuovic.skytravel.systemtest.legacy.mod08.smoke.external;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod08.base.BaseScenarioDslTest;
import org.junit.jupiter.api.Test;

class ErpSmokeTest extends BaseScenarioDslTest {
    @Test
    void shouldBeAbleToGoToErp() {
        scenario.assume().erp().shouldBeRunning();
    }
}

