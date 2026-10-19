package com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.when.steps;

import static com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ScenarioDefaults.*;

import com.valentinajemuovic.skytravel.testkit.common.Converter;
import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.scenario.ExecutionResultBuilder;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PlaceOrderResponse;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.when.steps.WhenPlaceOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.PlaceOrderVerification;

public class WhenPlaceOrderImpl extends BaseWhenStep<PlaceOrderResponse, PlaceOrderVerification> implements WhenPlaceOrder {
    private String orderNumber;
    private String sku;
    private String quantity;
    private String country;
    private String couponCode;

    public WhenPlaceOrderImpl(UseCaseDsl app, ScenarioDslImpl scenario) {
        super(app, scenario);
        withOrderNumber(DEFAULT_ORDER_NUMBER);
        withSku(DEFAULT_SKU);
        withQuantity(DEFAULT_QUANTITY);
        withCountry(DEFAULT_COUNTRY);
        withCouponCode(EMPTY);
    }

    public WhenPlaceOrderImpl withOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public WhenPlaceOrderImpl withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public WhenPlaceOrderImpl withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public WhenPlaceOrderImpl withQuantity(int quantity) {
        return withQuantity(Converter.fromInteger(quantity));
    }

    public WhenPlaceOrderImpl withCountry(String country) {
        this.country = country;
        return this;
    }

    public WhenPlaceOrderImpl withCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public WhenPlaceOrderImpl withCouponCode() {
        return withCouponCode(DEFAULT_COUPON_CODE);
    }

    @Override
    protected ExecutionResult<PlaceOrderResponse, PlaceOrderVerification> execute(UseCaseDsl app) {
        var result = app.skyTravel(ChannelMode.DYNAMIC).placeOrder()
                .orderNumber(orderNumber)
                .sku(sku)
                .quantity(quantity)
                .country(country)
                .couponCode(couponCode)
                .execute();

        return new ExecutionResultBuilder<>(result)
                .orderNumber(orderNumber)
                .couponCode(couponCode)
                .build();
    }
}
