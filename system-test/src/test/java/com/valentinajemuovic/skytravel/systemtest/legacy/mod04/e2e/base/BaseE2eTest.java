package com.valentinajemuovic.skytravel.systemtest.legacy.mod04.e2e.base;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import com.valentinajemuovic.skytravel.systemtest.legacy.mod04.base.BaseClientTest;

import org.junit.jupiter.api.BeforeEach;

public abstract class BaseE2eTest extends BaseClientTest {
    @BeforeEach
    void setUp() {
        setSkyTravelClient();
        setUpExternalClients();
    }

    protected abstract void setSkyTravelClient();

    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}



