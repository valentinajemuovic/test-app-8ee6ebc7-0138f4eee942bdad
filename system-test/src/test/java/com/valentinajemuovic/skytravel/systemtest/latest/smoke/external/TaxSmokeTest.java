package com.valentinajemuovic.skytravel.systemtest.latest.smoke.external;

import com.valentinajemuovic.skytravel.systemtest.latest.base.BaseScenarioDslTest;
import org.junit.jupiter.api.Test;

class TaxSmokeTest extends BaseScenarioDslTest {
    @Test
    void shouldBeAbleToGoToTax() {
        scenario.assume().tax().shouldBeRunning();
    }
}
