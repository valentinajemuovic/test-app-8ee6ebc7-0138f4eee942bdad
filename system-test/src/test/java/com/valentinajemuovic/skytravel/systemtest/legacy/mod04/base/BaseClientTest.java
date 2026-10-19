package com.valentinajemuovic.skytravel.systemtest.legacy.mod04.base;

import com.valentinajemuovic.skytravel.systemtest.configuration.BaseConfigurableTest;
import com.valentinajemuovic.skytravel.systemtest.configuration.Configuration;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.erp.client.ErpRealClient;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax.client.TaxRealClient;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client.SkyTravelApiClient;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.ui.client.SkyTravelUiClient;
import com.valentinajemuovic.skytravel.systemtest.infrastructure.playwright.BrowserLifecycleExtension;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseClientTest extends BaseConfigurableTest {
    protected Configuration configuration;

    protected SkyTravelUiClient skyTravelUiClient;
    protected SkyTravelApiClient skyTravelApiClient;
    protected ErpRealClient erpClient;
    protected TaxRealClient taxClient;

    @BeforeEach
    protected void setUpConfiguration() {
        configuration = loadConfiguration();
    }

    protected void setUpSkyTravelUiClient() {
        skyTravelUiClient = new SkyTravelUiClient(configuration.getSkyTravelUiBaseUrl(), BrowserLifecycleExtension.getBrowser(), configuration.getKeycloakBaseUrl());
    }

    protected void setUpSkyTravelApiClient() {
        skyTravelApiClient = new SkyTravelApiClient(configuration.getSkyTravelApiBaseUrl(), configuration.getKeycloakBaseUrl());
    }

    protected void setUpExternalClients() {
        erpClient = new ErpRealClient(configuration.getErpBaseUrl());
        taxClient = new TaxRealClient(configuration.getTaxBaseUrl());
    }

    @AfterEach
    void tearDown() {
        Closer.close(skyTravelUiClient);
        Closer.close(skyTravelApiClient);
        Closer.close(erpClient);
        Closer.close(taxClient);
    }

}
