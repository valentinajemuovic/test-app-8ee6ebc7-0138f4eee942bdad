package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.then.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.ErrorVerification;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.ResponseVerification;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResultContext;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenFailure;

public class ThenFailureImpl<R, V extends ResponseVerification<R>>
        extends BaseThenStep<Void, VoidVerification> implements ThenFailure {
    private final ErrorVerification failureVerification;

    public ThenFailureImpl(UseCaseDsl app, ExecutionResultContext executionResult,
            UseCaseResult<R, V> result) {
        super(app, executionResult, null);
        if (result == null) {
            throw new IllegalStateException("Cannot verify failure: no operation was executed");
        }
        this.failureVerification = result.shouldFail();
    }

    public ThenFailureImpl<R, V> errorMessage(String expectedMessage) {
        failureVerification.errorMessage(expectedMessage);
        return this;
    }

    public ThenFailureImpl<R, V> fieldErrorMessage(
            String expectedField, String expectedMessage) {
        failureVerification.fieldErrorMessage(expectedField, expectedMessage);
        return this;
    }

    @Override
    public ThenFailureImpl<R, V> and() {
        return this;
    }
}




