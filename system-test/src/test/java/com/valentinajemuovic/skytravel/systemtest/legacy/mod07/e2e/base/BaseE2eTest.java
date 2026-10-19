package com.valentinajemuovic.skytravel.systemtest.legacy.mod07.e2e.base;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod07.base.BaseUseCaseDslTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public abstract class BaseE2eTest extends BaseUseCaseDslTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}




