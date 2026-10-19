package com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base;

import com.valentinajemuovic.skytravel.systemtest.configuration.Configuration;
import com.valentinajemuovic.skytravel.systemtest.latest.base.BaseScenarioDslTest;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public abstract class BaseAcceptanceTest extends BaseScenarioDslTest {
    @Override
    protected Configuration loadConfiguration() {
        var configuration = super.loadConfiguration();
        requireKeycloakBaseUrl(configuration);
        return configuration;
    }

    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.STUB;
    }
}
