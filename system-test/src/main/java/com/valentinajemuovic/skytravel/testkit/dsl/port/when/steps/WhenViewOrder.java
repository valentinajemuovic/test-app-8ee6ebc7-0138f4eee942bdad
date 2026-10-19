package com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.base.WhenStep;

public interface WhenViewOrder extends WhenStep {
    WhenViewOrder withOrderNumber(String orderNumber);
}

