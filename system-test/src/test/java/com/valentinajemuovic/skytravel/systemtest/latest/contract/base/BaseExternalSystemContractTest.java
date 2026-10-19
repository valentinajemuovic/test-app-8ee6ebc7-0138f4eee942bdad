package com.valentinajemuovic.skytravel.systemtest.latest.contract.base;

import com.valentinajemuovic.skytravel.systemtest.latest.base.BaseScenarioDslTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseExternalSystemContractTest extends BaseScenarioDslTest {
    protected ScenarioDslImpl scenario;

    @BeforeEach
    void setUpScenario() {
        scenario = (ScenarioDslImpl) super.scenario;
    }

    @Override
    protected abstract ExternalSystemMode getFixedExternalSystemMode();
}
