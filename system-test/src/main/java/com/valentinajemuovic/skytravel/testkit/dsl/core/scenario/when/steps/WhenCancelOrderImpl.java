package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps;

import static com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ScenarioDefaults.DEFAULT_ORDER_NUMBER;

import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResultBuilder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenCancelOrder;

public class WhenCancelOrderImpl extends BaseWhenStep<Void, VoidVerification> implements WhenCancelOrder {
    private String orderNumber;

    public WhenCancelOrderImpl(UseCaseDsl app, ScenarioDslImpl scenario) {
        super(app, scenario);
        withOrderNumber(DEFAULT_ORDER_NUMBER);
    }

    public WhenCancelOrderImpl withOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    @Override
    protected ExecutionResult<Void, VoidVerification> execute(UseCaseDsl app) {
        var result = app.skyTravel(ChannelMode.DYNAMIC).cancelOrder()
                .orderNumber(orderNumber)
                .execute();

        return new ExecutionResultBuilder<Void, VoidVerification>(result)
                .orderNumber(orderNumber)
                .build();
    }
}
