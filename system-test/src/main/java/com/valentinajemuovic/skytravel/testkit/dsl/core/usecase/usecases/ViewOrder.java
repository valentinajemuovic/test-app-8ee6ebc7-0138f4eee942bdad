package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.ViewOrderRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.ViewOrderResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;

public class ViewOrder extends BaseSkyTravelUseCase<ViewOrderResponse, ViewOrderVerification> {
    private String orderNumberResultAlias;

    public ViewOrder(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    public ViewOrder orderNumber(String orderNumberResultAlias) {
        this.orderNumberResultAlias = orderNumberResultAlias;
        return this;
    }

    @Override
    public UseCaseResult<ViewOrderResponse, ViewOrderVerification> execute() {
        var orderNumber = context.getResultValue(orderNumberResultAlias);

        var request = ViewOrderRequest.builder().orderNumber(orderNumber).build();
        var result = driver.viewOrder(request);

        return new UseCaseResult<>(result, context, ViewOrderVerification::new);
    }
}



