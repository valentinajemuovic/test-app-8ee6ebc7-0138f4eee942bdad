package com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.base.ThenStep;

public interface ThenFailure extends ThenStep<ThenFailure> {
    ThenFailure errorMessage(String expectedMessage);

    ThenFailure fieldErrorMessage(String expectedField, String expectedMessage);
}

