package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.GoToSkyTravelRequest;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;

public class GoToSkyTravel extends BaseSkyTravelUseCase<Void, VoidVerification> {
    public GoToSkyTravel(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    @Override
    public UseCaseResult<Void, VoidVerification> execute() {
        var request = GoToSkyTravelRequest.builder().build();
        var result = driver.goToSkyTravel(request).mapVoid();
        return new UseCaseResult<>(result, context, VoidVerification::new);
    }
}



