package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps;

import static com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ScenarioDefaults.DEFAULT_ORDER_NUMBER;

import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResultBuilder;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseOrderHistoryResponse;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenBrowseOrderHistory;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.BrowseOrderHistoryVerification;

public class WhenBrowseOrderHistoryImpl extends BaseWhenStep<BrowseOrderHistoryResponse, BrowseOrderHistoryVerification> implements WhenBrowseOrderHistory {
    private String orderNumber;

    public WhenBrowseOrderHistoryImpl(UseCaseDsl app, ScenarioDslImpl scenario) {
        super(app, scenario);
        withOrderNumber(DEFAULT_ORDER_NUMBER);
    }

    public WhenBrowseOrderHistoryImpl withOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    @Override
    protected ExecutionResult<BrowseOrderHistoryResponse, BrowseOrderHistoryVerification> execute(UseCaseDsl app) {
        var result = app.skyTravel(ChannelMode.DYNAMIC).browseOrderHistory()
                .orderNumber(orderNumber)
                .execute();

        return new ExecutionResultBuilder<>(result)
                .orderNumber(orderNumber)
                .build();
    }
}
