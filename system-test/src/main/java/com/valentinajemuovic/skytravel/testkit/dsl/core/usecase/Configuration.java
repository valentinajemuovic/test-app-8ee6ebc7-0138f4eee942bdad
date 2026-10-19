package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase;

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
    private final ExternalSystemMode externalSystemMode;
}
