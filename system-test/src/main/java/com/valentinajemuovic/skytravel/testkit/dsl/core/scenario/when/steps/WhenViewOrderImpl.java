package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps;

import static com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ScenarioDefaults.DEFAULT_ORDER_NUMBER;

import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResultBuilder;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.ViewOrderResponse;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenViewOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.ViewOrderVerification;

public class WhenViewOrderImpl extends BaseWhenStep<ViewOrderResponse, ViewOrderVerification> implements WhenViewOrder {
    private String orderNumber;

    public WhenViewOrderImpl(UseCaseDsl app, ScenarioDslImpl scenario) {
        super(app, scenario);
        withOrderNumber(DEFAULT_ORDER_NUMBER);
    }

    public WhenViewOrderImpl withOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    @Override
    protected ExecutionResult<ViewOrderResponse, ViewOrderVerification> execute(UseCaseDsl app) {
        var result = app.skyTravel(ChannelMode.DYNAMIC).viewOrder()
                .orderNumber(orderNumber)
                .execute();

        return new ExecutionResultBuilder<>(result)
                .orderNumber(orderNumber)
                .build();
    }
}
