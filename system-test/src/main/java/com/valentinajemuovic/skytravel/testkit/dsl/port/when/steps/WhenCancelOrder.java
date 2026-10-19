package com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.base.WhenStep;

public interface WhenCancelOrder extends WhenStep {
    WhenCancelOrder withOrderNumber(String orderNumber);
}
