package com.valentinajemuovic.skytravel.systemtest.legacy.mod02.smoke.system;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod02.base.BaseRawTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

class SkyTravelApiSmokeTest extends BaseRawTest {
    private static final String HEALTH_ENDPOINT = "/health";

    @BeforeEach
    void setUp() {
        setUpSkyTravelHttpClient();
    }

    @Test
    void shouldBeAbleToGoToSkyTravel() throws Exception {
        var uri = URI.create(getSkyTravelApiBaseUrl() + HEALTH_ENDPOINT);
        var request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        var response = skyTravelApiHttpClient.send(request, HttpResponse.BodyHandlers.ofString());

        assertThat(response.statusCode()).isEqualTo(200);
    }
}


