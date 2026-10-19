package com.valentinajemuovic.skytravel.systemtest.legacy.mod05.base;

import com.valentinajemuovic.skytravel.systemtest.configuration.BaseConfigurableTest;
import com.valentinajemuovic.skytravel.systemtest.configuration.Configuration;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.erp.ErpRealDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax.TaxRealDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.SkyTravelApiDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.ui.SkyTravelUiDriver;
import com.valentinajemuovic.skytravel.systemtest.infrastructure.playwright.BrowserLifecycleExtension;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseDriverTest extends BaseConfigurableTest {
    protected Configuration configuration;

    protected SkyTravelDriver skyTravelDriver;
    protected ErpRealDriver erpDriver;
    protected TaxRealDriver taxDriver;

    @BeforeEach
    protected void setUpConfiguration() {
        configuration = loadConfiguration();
    }

    protected void setUpSkyTravelUiDriver() {
        skyTravelDriver = new SkyTravelUiDriver(configuration.getSkyTravelUiBaseUrl(), BrowserLifecycleExtension.getBrowser(), configuration.getKeycloakBaseUrl());
    }

    protected void setUpSkyTravelApiDriver() {
        skyTravelDriver = new SkyTravelApiDriver(configuration.getSkyTravelApiBaseUrl(), configuration.getKeycloakBaseUrl());
    }

    protected void setUpExternalDrivers() {
        erpDriver = new ErpRealDriver(configuration.getErpBaseUrl());
        taxDriver = new TaxRealDriver(configuration.getTaxBaseUrl());
    }

    @AfterEach
    void tearDown() {
        Closer.close(skyTravelDriver);
        Closer.close(erpDriver);
        Closer.close(taxDriver);
    }
}
