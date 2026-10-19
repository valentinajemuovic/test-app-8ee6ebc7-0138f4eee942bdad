package com.valentinajemuovic.skytravel.systemtest.latest.dsl;

import com.valentinajemuovic.skytravel.testkit.common.Result;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseCouponsResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PlaceOrderResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PublishCouponRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PublishCouponResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.ErpDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.dtos.ReturnsProductRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.dtos.ReturnsPromotionRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.TaxDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.dtos.ReturnsTaxRateRequest;
import com.valentinajemuovic.skytravel.testkit.dsl.core.ScenarioDslImpl;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.UseCaseDsl;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ChannelMode;
import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Runs without Docker: the DSL is wired to mocked drivers.
class DefaultGivensTest {
    private final ErpDriver erp = mock(ErpDriver.class);
    private final TaxDriver tax = mock(TaxDriver.class);
    private final SkyTravelDriver shop = mock(SkyTravelDriver.class);

    private ScenarioDslImpl scenario() {
        when(erp.returnsProduct(any())).thenReturn(Result.success());
        when(erp.returnsPromotion(any())).thenReturn(Result.success());
        when(tax.returnsTaxRate(any())).thenReturn(Result.success());
        when(shop.placeOrder(any())).thenReturn(Result.success(new PlaceOrderResponse("ORD-1")));
        when(shop.browseCoupons(any())).thenReturn(Result.success(new BrowseCouponsResponse()));
        when(shop.publishCoupon(any())).thenReturn(Result.success(new PublishCouponResponse()));

        var app = new UseCaseDsl(ExternalSystemMode.STUB, ChannelMode.STATIC, channel -> shop, () -> erp, () -> null, () -> tax);
        return new ScenarioDslImpl(app);
    }

    @Test
    void orderWithoutDeclaredProductShouldCreateDefaultProductAndTaxRateExactlyOnce() {
        scenario()
                .given().order()
                .when().placeOrder().withOrderNumber("WHEN-ORDER")
                .then().shouldSucceed();

        verify(erp, times(1)).returnsProduct(any(ReturnsProductRequest.class));
        verify(tax, times(1)).returnsTaxRate(any(ReturnsTaxRateRequest.class));
        verify(shop, times(1)).publishCoupon(any(PublishCouponRequest.class));
    }

    @Test
    void whenWithoutOrdersShouldNotCreateDefaultCoupon() {
        scenario()
                .when().browseCoupons()
                .then().shouldSucceed();

        verify(erp, times(1)).returnsPromotion(any(ReturnsPromotionRequest.class));
        verify(shop, never()).publishCoupon(any());
    }
}
