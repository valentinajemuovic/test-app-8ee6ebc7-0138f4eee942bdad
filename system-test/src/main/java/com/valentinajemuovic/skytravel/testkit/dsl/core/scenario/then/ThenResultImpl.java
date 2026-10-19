package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.then;

import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.ResponseVerification;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.then.steps.ThenFailureImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.then.steps.ThenSuccessImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.ThenResultStage;

public class ThenResultImpl<R, V extends ResponseVerification<R>> extends ThenImpl implements ThenResultStage {
    private final ExecutionResult<R, V> executionResult;

    public ThenResultImpl(UseCaseDsl app, ExecutionResult<R, V> executionResult) {
        super(app);
        this.executionResult = executionResult;
    }

    @Override
    public ThenSuccessImpl<R, V> shouldSucceed() {
        var successVerification = executionResult.getResult().shouldSucceed();
        return new ThenSuccessImpl<>(app, executionResult.getContext(), successVerification);
    }

    @Override
    public ThenFailureImpl<R, V> shouldFail() {
        return new ThenFailureImpl<>(app, executionResult.getContext(), executionResult.getResult());
    }
}


