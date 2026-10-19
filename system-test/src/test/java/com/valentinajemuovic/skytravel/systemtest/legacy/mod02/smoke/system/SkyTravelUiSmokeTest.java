package com.valentinajemuovic.skytravel.systemtest.legacy.mod02.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod02.base.BaseRawTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SkyTravelUiSmokeTest extends BaseRawTest {
    @BeforeEach
    void setUp() {
        setUpSkyTravelBrowser();
    }

    @Test
    void shouldBeAbleToGoToSkyTravel() {
        var response = skyTravelUiPage.navigate(getSkyTravelUiBaseUrl());

        assertThat(response.status()).isEqualTo(200);

        loginToSkyTravelUiIfRequired();

        var contentType = response.headers().get("content-type");
        assertThat(contentType).isNotNull().contains("text/html");

        var pageContent = skyTravelUiPage.content();
        assertThat(pageContent).contains("<html").contains("</html>");
    }
}


