package com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.base.ThenStep;

public interface ThenClock extends ThenStep<ThenClock> {
    ThenClock hasTime(String time);

    ThenClock hasTime();
}

