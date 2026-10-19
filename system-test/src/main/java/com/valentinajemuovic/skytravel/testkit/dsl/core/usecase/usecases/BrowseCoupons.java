package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseCouponsRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseCouponsResponse;

public class BrowseCoupons extends BaseSkyTravelUseCase<BrowseCouponsResponse, BrowseCouponsVerification> {
    public BrowseCoupons(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    @Override
    public UseCaseResult<BrowseCouponsResponse, BrowseCouponsVerification> execute() {
        var request = BrowseCouponsRequest.builder().build();
        var result = driver.browseCoupons(request);
        return new UseCaseResult<>(result, context, BrowseCouponsVerification::new);
    }
}
