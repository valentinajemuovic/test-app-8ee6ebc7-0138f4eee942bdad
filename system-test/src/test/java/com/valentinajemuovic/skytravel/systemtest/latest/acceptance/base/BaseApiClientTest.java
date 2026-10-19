package com.valentinajemuovic.skytravel.systemtest.latest.acceptance.base;

import com.valentinajemuovic.skytravel.systemtest.configuration.BaseConfigurableTest;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client.SkyTravelApiClient;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseApiClientTest extends BaseConfigurableTest {
    protected SkyTravelApiClient skyTravelApiClient;

    @BeforeEach
    void setUpApiClient() {
        var configuration = loadConfiguration();
        var keycloakBaseUrl = requireKeycloakBaseUrl(configuration);
        skyTravelApiClient = new SkyTravelApiClient(configuration.getSkyTravelApiBaseUrl(), keycloakBaseUrl);
    }

    @AfterEach
    void tearDownApiClient() {
        Closer.close(skyTravelApiClient);
    }

    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.STUB;
    }
}
