package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.DeliverOrderRequest;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;

public class DeliverOrder extends BaseSkyTravelUseCase<Void, VoidVerification> {
    private String orderNumberResultAlias;

    public DeliverOrder(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    public DeliverOrder orderNumber(String orderNumberResultAlias) {
        this.orderNumberResultAlias = orderNumberResultAlias;
        return this;
    }

    @Override
    public UseCaseResult<Void, VoidVerification> execute() {
        var orderNumber = context.getResultValue(orderNumberResultAlias);
        var request = DeliverOrderRequest.builder().orderNumber(orderNumber).build();
        var result = driver.deliverOrder(request).mapVoid();
        return new UseCaseResult<>(result, context, VoidVerification::new);
    }
}
