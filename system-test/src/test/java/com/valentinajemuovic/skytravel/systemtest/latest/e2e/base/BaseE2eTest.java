package com.valentinajemuovic.skytravel.systemtest.latest.e2e.base;

import com.valentinajemuovic.skytravel.systemtest.latest.base.BaseScenarioDslTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public abstract class BaseE2eTest extends BaseScenarioDslTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}




