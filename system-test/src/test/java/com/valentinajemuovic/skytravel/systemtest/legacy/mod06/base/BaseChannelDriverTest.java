package com.valentinajemuovic.skytravel.systemtest.legacy.mod06.base;

import com.valentinajemuovic.skytravel.systemtest.configuration.BaseConfigurableTest;
import com.valentinajemuovic.skytravel.systemtest.configuration.Configuration;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.erp.ErpRealDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax.TaxRealDriver;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.SkyTravelApiDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.ui.SkyTravelUiDriver;
import com.valentinajemuovic.skytravel.systemtest.infrastructure.playwright.BrowserLifecycleExtension;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import com.optivem.testing.contexts.ChannelContext;
import com.optivem.testing.extensions.ChannelExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ChannelExtension.class)
public abstract class BaseChannelDriverTest extends BaseConfigurableTest {
    protected SkyTravelDriver skyTravelDriver;
    protected ErpRealDriver erpDriver;
    protected TaxRealDriver taxDriver;

    @BeforeEach
    void setUp() {
        var configuration = loadConfiguration();

        skyTravelDriver = createChannelSkyTravelDriver(configuration);
        erpDriver = new ErpRealDriver(configuration.getErpBaseUrl());
        taxDriver = new TaxRealDriver(configuration.getTaxBaseUrl());
    }

    @AfterEach
    void tearDown() {
        Closer.close(skyTravelDriver);
        Closer.close(erpDriver);
        Closer.close(taxDriver);
    }

    private SkyTravelDriver createChannelSkyTravelDriver(Configuration configuration) {
        var channel = ChannelContext.get();

        if(channel == null) {
            return null;
        }

        if (ChannelType.UI.equals(channel)) {
            return new SkyTravelUiDriver(configuration.getSkyTravelUiBaseUrl(), BrowserLifecycleExtension.getBrowser(), configuration.getKeycloakBaseUrl());
        } else if (ChannelType.API.equals(channel)) {
            return new SkyTravelApiDriver(configuration.getSkyTravelApiBaseUrl(), configuration.getKeycloakBaseUrl());
        } else {
            throw new IllegalStateException("Unknown channel: " + channel);
        }
    }
}
