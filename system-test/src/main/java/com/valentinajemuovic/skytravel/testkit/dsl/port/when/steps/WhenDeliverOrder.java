package com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.base.WhenStep;

public interface WhenDeliverOrder extends WhenStep {
    WhenDeliverOrder withOrderNumber(String orderNumber);
}
