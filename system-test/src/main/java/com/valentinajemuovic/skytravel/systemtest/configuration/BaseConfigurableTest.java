package com.valentinajemuovic.skytravel.systemtest.configuration;

import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.ClockDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.ErpDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.TaxDriver;
import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.clock.ClockRealDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.clock.ClockStubDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.erp.ErpRealDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.erp.ErpStubDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax.TaxRealDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax.TaxStubDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.SkyTravelApiDriver;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.ui.SkyTravelUiDriver;
import com.valentinajemuovic.skytravel.systemtest.infrastructure.playwright.BrowserLifecycleExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BrowserLifecycleExtension.class)
public abstract class BaseConfigurableTest {
    protected Environment getFixedEnvironment() {
        return null;
    }

    protected ExternalSystemMode getFixedExternalSystemMode() {
        return null;
    }

    protected ChannelMode getFixedChannelMode() {
        return null;
    }

    protected Configuration loadConfiguration() {
        var environment = PropertyLoader.getEnvironment(getFixedEnvironment());
        var externalSystemMode = PropertyLoader.getExternalSystemMode(getFixedExternalSystemMode());
        var channelMode = PropertyLoader.getChannelMode(getFixedChannelMode());

        return ConfigurationLoader.load(environment, externalSystemMode, channelMode);
    }

    protected String requireKeycloakBaseUrl(Configuration configuration) {
        var keycloakBaseUrl = configuration.getKeycloakBaseUrl();
        if (keycloakBaseUrl == null || keycloakBaseUrl.isBlank()) {
            var suffix = "_" + configuration.getExternalSystemMode().name().toUpperCase();
            throw new IllegalStateException("Keycloak base URL is not configured. Set the environment variable KEYCLOAK_URL"
                    + suffix + " (or KEYCLOAK_URL) to the Keycloak base URL, e.g. http://localhost:8180, "
                    + "and start the Keycloak container before running these tests.");
        }
        return keycloakBaseUrl;
    }

    protected UseCaseDsl createUseCaseDsl(Configuration configuration) {
        return new UseCaseDsl(
                configuration.getExternalSystemMode(),
                configuration.getChannelMode(),
                channel -> createSkyTravelDriverForChannel(configuration, channel),
                () -> createErpDriver(configuration),
                () -> createClockDriver(configuration),
                () -> createTaxDriver(configuration)
        );
    }

    private SkyTravelDriver createSkyTravelDriverForChannel(Configuration configuration, String channel) {
        if (ChannelType.UI.equals(channel)) {
            return new SkyTravelUiDriver(configuration.getSkyTravelUiBaseUrl(), BrowserLifecycleExtension.getBrowser(), configuration.getKeycloakBaseUrl());
        } else if (ChannelType.API.equals(channel)) {
            return new SkyTravelApiDriver(configuration.getSkyTravelApiBaseUrl(), configuration.getKeycloakBaseUrl());
        } else {
            throw new IllegalStateException("Unknown channel: " + channel);
        }
    }

    private ErpDriver createErpDriver(Configuration configuration) {
        return switch (configuration.getExternalSystemMode()) {
            case REAL -> new ErpRealDriver(configuration.getErpBaseUrl());
            case STUB -> new ErpStubDriver(configuration.getErpBaseUrl());
        };
    }

    private ClockDriver createClockDriver(Configuration configuration) {
        return switch (configuration.getExternalSystemMode()) {
            case REAL -> new ClockRealDriver();
            case STUB -> new ClockStubDriver(configuration.getClockBaseUrl());
        };
    }

    private TaxDriver createTaxDriver(Configuration configuration) {
        return switch (configuration.getExternalSystemMode()) {
            case REAL -> new TaxRealDriver(configuration.getTaxBaseUrl());
            case STUB -> new TaxStubDriver(configuration.getTaxBaseUrl());
        };
    }
}
