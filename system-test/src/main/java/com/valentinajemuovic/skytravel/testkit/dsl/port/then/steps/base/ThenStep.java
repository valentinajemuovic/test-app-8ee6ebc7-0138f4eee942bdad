package com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.base;

import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenClock;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenCountry;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenCoupon;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenOrderHistory;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.steps.ThenProduct;

public interface ThenStep<T> {
    T and();

    ThenOrder order();

    ThenOrder order(String orderNumber);

    ThenOrderHistory orderHistory();

    ThenCoupon coupon();

    ThenCoupon coupon(String couponCode);

    ThenClock clock();

    ThenProduct product(String skuAlias);

    ThenCountry country(String countryAlias);
}
