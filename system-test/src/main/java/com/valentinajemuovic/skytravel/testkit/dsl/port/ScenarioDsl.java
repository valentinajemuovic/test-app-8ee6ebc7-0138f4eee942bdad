package com.valentinajemuovic.skytravel.testkit.dsl.port;

import com.valentinajemuovic.skytravel.testkit.dsl.port.assume.AssumeStage;
import com.valentinajemuovic.skytravel.testkit.dsl.port.given.GivenStage;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.WhenStage;

public interface ScenarioDsl {
    AssumeStage assume();

    GivenStage given();

    WhenStage when();
}