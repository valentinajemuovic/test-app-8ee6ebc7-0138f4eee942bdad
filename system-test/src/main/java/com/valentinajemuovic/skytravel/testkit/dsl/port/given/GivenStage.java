package com.valentinajemuovic.skytravel.testkit.dsl.port.given;

import com.valentinajemuovic.skytravel.testkit.dsl.port.given.steps.GivenClock;
import com.valentinajemuovic.skytravel.testkit.dsl.port.given.steps.GivenCoupon;
import com.valentinajemuovic.skytravel.testkit.dsl.port.given.steps.GivenCountry;
import com.valentinajemuovic.skytravel.testkit.dsl.port.given.steps.GivenOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.port.given.steps.GivenProduct;
import com.valentinajemuovic.skytravel.testkit.dsl.port.given.steps.GivenPromotion;
import com.valentinajemuovic.skytravel.testkit.dsl.port.then.ThenStage;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.WhenStage;

public interface GivenStage {
    GivenClock clock();

    GivenProduct product();

    GivenPromotion promotion();

    GivenOrder order();

    GivenCountry country();

    GivenCoupon coupon();

    /** Logs in as the default customer (customer1). */
    GivenStage loggedInAsCustomer();

    /** Logs in as the customer known in this scenario by the given alias. */
    GivenStage loggedInAsCustomer(String alias);

    GivenStage loggedInAsAdmin();

    GivenStage notLoggedIn();

    WhenStage when();

    ThenStage then();
}
