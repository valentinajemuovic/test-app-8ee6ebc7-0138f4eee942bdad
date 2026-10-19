package com.valentinajemuovic.skytravel.systemtest.legacy.mod05.e2e.base;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod05.base.BaseDriverTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseE2eTest extends BaseDriverTest {
    @BeforeEach
    void setUpDrivers() {
        setSkyTravelDriver();
        setUpExternalDrivers();
    }

    protected abstract void setSkyTravelDriver();

    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}