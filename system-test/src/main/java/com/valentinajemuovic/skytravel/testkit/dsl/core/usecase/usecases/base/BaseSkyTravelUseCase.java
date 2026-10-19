package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base;

import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.BaseUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;

public abstract class BaseSkyTravelUseCase<R, V> extends BaseUseCase<SkyTravelDriver, R, V> {
    protected BaseSkyTravelUseCase(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }
}



