package com.valentinajemuovic.skytravel.systemtest.configuration;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Configuration {
    private final String skyTravelUiBaseUrl;
    private final String skyTravelApiBaseUrl;
    private final String erpBaseUrl;
    private final String clockBaseUrl;
    private final String taxBaseUrl;
    private final String keycloakBaseUrl;
    private final ExternalSystemMode externalSystemMode;
    private final ChannelMode channelMode;
}
