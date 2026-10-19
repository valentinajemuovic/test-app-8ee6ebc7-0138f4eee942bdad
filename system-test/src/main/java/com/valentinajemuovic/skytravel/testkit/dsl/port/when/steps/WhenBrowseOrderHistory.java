package com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.base.WhenStep;

public interface WhenBrowseOrderHistory extends WhenStep {
    WhenBrowseOrderHistory withOrderNumber(String orderNumber);
}
