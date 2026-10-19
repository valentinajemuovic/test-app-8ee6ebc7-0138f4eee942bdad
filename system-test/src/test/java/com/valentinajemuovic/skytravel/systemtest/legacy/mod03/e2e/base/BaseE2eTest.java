package com.valentinajemuovic.skytravel.systemtest.legacy.mod03.e2e.base;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import com.valentinajemuovic.skytravel.systemtest.legacy.mod03.base.BaseRawTest;

import org.junit.jupiter.api.BeforeEach;

public abstract class BaseE2eTest extends BaseRawTest {
    @BeforeEach
    void setUp() {
        setSkyTravelClient();
        setUpExternalHttpClients();
    }

    protected abstract void setSkyTravelClient();

    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}



