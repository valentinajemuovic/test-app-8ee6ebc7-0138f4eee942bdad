package com.valentinajemuovic.skytravel.systemtest.legacy.mod11.e2e.base;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod11.base.BaseScenarioDslTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public abstract class BaseE2eTest extends BaseScenarioDslTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}




