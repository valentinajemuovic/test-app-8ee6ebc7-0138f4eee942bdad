package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResultBuilder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.BrowseCouponsVerification;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseCouponsResponse;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenBrowseCoupons;

public class WhenBrowseCouponsImpl extends BaseWhenStep<BrowseCouponsResponse, BrowseCouponsVerification> implements WhenBrowseCoupons {

    public WhenBrowseCouponsImpl(UseCaseDsl app, ScenarioDslImpl scenario) {
        super(app, scenario);
    }

    @Override
    protected ExecutionResult<BrowseCouponsResponse, BrowseCouponsVerification> execute(UseCaseDsl app) {
        var result = app.skyTravel(ChannelMode.DYNAMIC).browseCoupons().execute();
        return new ExecutionResultBuilder<>(result).build();
    }
}
