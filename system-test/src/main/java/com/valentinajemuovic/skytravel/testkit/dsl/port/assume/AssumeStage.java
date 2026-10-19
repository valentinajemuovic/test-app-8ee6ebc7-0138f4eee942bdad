package com.valentinajemuovic.skytravel.testkit.dsl.port.assume;

import com.valentinajemuovic.skytravel.testkit.dsl.port.assume.steps.AssumeRunning;

public interface AssumeStage {
    AssumeRunning skyTravel();

    AssumeRunning erp();

    AssumeRunning tax();

    AssumeRunning clock();
}
