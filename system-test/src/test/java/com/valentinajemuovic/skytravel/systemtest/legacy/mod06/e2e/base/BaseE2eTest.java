package com.valentinajemuovic.skytravel.systemtest.legacy.mod06.e2e.base;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod06.base.BaseChannelDriverTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public abstract class BaseE2eTest extends BaseChannelDriverTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}



