package com.valentinajemuovic.skytravel.testkit.dsl.port.when;

import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenBrowseCoupons;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenBrowseOrderHistory;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenCancelOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenDeliverOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenPlaceOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenPublishCoupon;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenViewOrder;

public interface WhenStage {
    WhenPlaceOrder placeOrder();

    WhenCancelOrder cancelOrder();

    WhenDeliverOrder deliverOrder();

    WhenViewOrder viewOrder();

    WhenPublishCoupon publishCoupon();

    WhenBrowseCoupons browseCoupons();

    WhenBrowseOrderHistory browseOrderHistory();
}
