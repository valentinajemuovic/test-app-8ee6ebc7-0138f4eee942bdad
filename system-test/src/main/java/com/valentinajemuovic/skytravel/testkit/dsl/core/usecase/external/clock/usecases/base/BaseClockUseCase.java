package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.clock.usecases.base;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.clock.ClockDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.BaseUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;

public abstract class BaseClockUseCase<R, V> extends BaseUseCase<ClockDriver, R, V> {
    protected BaseClockUseCase(ClockDriver driver, UseCaseContext context) {
        super(driver, context);
    }
}
