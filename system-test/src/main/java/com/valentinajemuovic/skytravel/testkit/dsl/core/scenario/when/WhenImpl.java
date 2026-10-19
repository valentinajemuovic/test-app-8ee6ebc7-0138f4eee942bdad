package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when;

import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.DefaultGivens;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenBrowseCouponsImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenBrowseOrderHistoryImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenCancelOrderImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenDeliverOrderImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenPlaceOrderImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenPublishCouponImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.BaseWhenStep;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps.WhenViewOrderImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.WhenStage;

public class WhenImpl implements WhenStage {
    private final UseCaseDsl app;
    private final ScenarioDslImpl scenario;
    private final DefaultGivens defaults;

    public WhenImpl(UseCaseDsl app, ScenarioDslImpl scenario, DefaultGivens defaults) {
        this.app = app;
        this.scenario = scenario;
        this.defaults = defaults;
    }

    public WhenImpl(UseCaseDsl app, ScenarioDslImpl scenario) {
        this(app, scenario, new DefaultGivens(app));
    }

    private void ensureDefaults() {
        defaults.ensure(true);
    }

    public WhenPlaceOrderImpl placeOrder() {
        ensureDefaults();
        return new WhenPlaceOrderImpl(app, scenario);
    }

    public WhenCancelOrderImpl cancelOrder() {
        ensureDefaults();
        return new WhenCancelOrderImpl(app, scenario);
    }

    public WhenDeliverOrderImpl deliverOrder() {
        ensureDefaults();
        return new WhenDeliverOrderImpl(app, scenario);
    }

    public WhenViewOrderImpl viewOrder() {
        ensureDefaults();
        return new WhenViewOrderImpl(app, scenario);
    }

    public WhenBrowseOrderHistoryImpl browseOrderHistory() {
        ensureDefaults();
        return new WhenBrowseOrderHistoryImpl(app, scenario);
    }

    public WhenPublishCouponImpl publishCoupon() {
        ensureDefaults();
        return new WhenPublishCouponImpl(app, scenario);
    }

    public WhenBrowseCouponsImpl browseCoupons() {
        ensureDefaults();
        return new WhenBrowseCouponsImpl(app, scenario);
    }

}
