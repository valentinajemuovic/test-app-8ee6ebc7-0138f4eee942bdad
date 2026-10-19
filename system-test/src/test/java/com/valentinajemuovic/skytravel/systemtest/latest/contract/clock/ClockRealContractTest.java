package com.valentinajemuovic.skytravel.systemtest.latest.contract.clock;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

class ClockRealContractTest extends BaseClockContractTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}
