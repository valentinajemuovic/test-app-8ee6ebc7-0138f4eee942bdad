package com.valentinajemuovic.skytravel.systemtest.legacy.mod10.base;

import com.valentinajemuovic.skytravel.systemtest.configuration.BaseConfigurableTest;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ScenarioDsl;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import com.valentinajemuovic.skytravel.systemtest.infrastructure.playwright.BrowserLifecycleExtension;
import com.optivem.testing.extensions.ChannelExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ChannelExtension.class, BrowserLifecycleExtension.class})
public abstract class BaseScenarioDslTest extends BaseConfigurableTest {
    private UseCaseDsl app;
    protected ScenarioDsl scenario;

    @BeforeEach
    void setUp() {
        var configuration = loadConfiguration();
        app = createUseCaseDsl(configuration);
        scenario = new ScenarioDslImpl(app);
    }

    @AfterEach
    void tearDown() {
        Closer.close(app);
    }
}

