package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.CancelOrderRequest;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;

public class CancelOrder extends BaseSkyTravelUseCase<Void, VoidVerification> {
    private String orderNumberResultAlias;

    public CancelOrder(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    public CancelOrder orderNumber(String orderNumberResultAlias) {
        this.orderNumberResultAlias = orderNumberResultAlias;
        return this;
    }

    @Override
    public UseCaseResult<Void, VoidVerification> execute() {
        var orderNumber = context.getResultValue(orderNumberResultAlias);
        var request = CancelOrderRequest.builder().orderNumber(orderNumber).build();
        var result = driver.cancelOrder(request).mapVoid();
        return new UseCaseResult<>(result, context, VoidVerification::new);
    }
}
