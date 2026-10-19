package com.valentinajemuovic.skytravel.testkit.driver.port.external.clock;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.dtos.GetTimeResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.dtos.ReturnsTimeRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.dtos.error.ClockErrorResponse;
import com.valentinajemuovic.skytravel.testkit.common.Result;

public interface ClockDriver extends AutoCloseable {
    Result<Void, ClockErrorResponse> goToClock();
    Result<GetTimeResponse, ClockErrorResponse> getTime();
    Result<Void, ClockErrorResponse> returnsTime(ReturnsTimeRequest request);
}
