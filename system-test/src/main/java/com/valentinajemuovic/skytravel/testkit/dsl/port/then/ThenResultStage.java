package com.valentinajemuovic.skytravel.testkit.dsl.port.then;

import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenFailure;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenSuccess;

public interface ThenResultStage extends ThenStage {
    ThenSuccess shouldSucceed();

    ThenFailure shouldFail();
}
