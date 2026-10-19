package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.clock.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.ClockDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.dtos.GetTimeResponse;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.clock.usecases.base.BaseClockUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.error.SystemError;

public class GetTime extends BaseClockUseCase<GetTimeResponse, GetTimeVerification> {
    public GetTime(ClockDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    @Override
    public UseCaseResult<GetTimeResponse, GetTimeVerification> execute() {
        var result = driver.getTime();
        return new UseCaseResult<>(result.mapError(e -> SystemError.of(e.getMessage())), context, GetTimeVerification::new);
    }
}
