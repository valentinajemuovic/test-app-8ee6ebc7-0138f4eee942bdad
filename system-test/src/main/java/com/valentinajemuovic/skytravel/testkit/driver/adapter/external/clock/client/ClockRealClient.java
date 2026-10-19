package com.valentinajemuovic.skytravel.testkit.driver.adapter.external.clock.client;

import com.valentinajemuovic.skytravel.testkit.common.Result;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.clock.client.dtos.ExtGetTimeResponse;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.clock.client.dtos.error.ExtClockErrorResponse;

import java.time.Instant;

public class ClockRealClient {
    public Result<Void, ExtClockErrorResponse> checkHealth() {
        now();
        return Result.success();
    }

    public Result<ExtGetTimeResponse, ExtClockErrorResponse> getTime() {
        var response = ExtGetTimeResponse.builder()
                .time(now())
                .build();
        return Result.success(response);
    }

    private static Instant now() {
        return Instant.now();
    }
}
