package com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps;

import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.base.ThenStep;

public interface ThenOrderHistory extends ThenStep<ThenOrderHistory> {
    ThenOrderHistory containsOrder(String orderNumber);

    ThenOrderHistory doesNotContainOrder(String orderNumber);
}
