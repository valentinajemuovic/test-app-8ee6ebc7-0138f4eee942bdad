package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseOrderHistoryRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseOrderHistoryResponse;

public class BrowseOrderHistory extends BaseSkyTravelUseCase<BrowseOrderHistoryResponse, BrowseOrderHistoryVerification> {
    private String orderNumberResultAlias;

    public BrowseOrderHistory(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    public BrowseOrderHistory orderNumber(String orderNumberResultAlias) {
        this.orderNumberResultAlias = orderNumberResultAlias;
        return this;
    }

    @Override
    public UseCaseResult<BrowseOrderHistoryResponse, BrowseOrderHistoryVerification> execute() {
        var orderNumber = context.getResultValue(orderNumberResultAlias);

        var request = BrowseOrderHistoryRequest.builder().orderNumber(orderNumber).build();
        var result = driver.browseOrderHistory(request);

        return new UseCaseResult<>(result, context, BrowseOrderHistoryVerification::new);
    }
}
