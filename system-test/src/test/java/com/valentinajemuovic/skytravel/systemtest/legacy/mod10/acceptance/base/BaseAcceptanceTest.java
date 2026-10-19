package com.valentinajemuovic.skytravel.systemtest.legacy.mod10.acceptance.base;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod10.base.BaseScenarioDslTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public abstract class BaseAcceptanceTest extends BaseScenarioDslTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.STUB;
    }
}



