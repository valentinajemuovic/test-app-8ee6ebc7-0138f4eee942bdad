package com.valentinajemuovic.skytravel.testkit.driver.port;

import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.error.SystemError;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseCouponsRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseOrderHistoryRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseOrderHistoryResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.BrowseCouponsResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.CancelOrderRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.CancelOrderResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.DeliverOrderRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.DeliverOrderResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.GoToSkyTravelRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.GoToSkyTravelResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PlaceOrderRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PlaceOrderResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PublishCouponRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PublishCouponResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.ViewOrderRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.ViewOrderResponse;
import com.valentinajemuovic.skytravel.testkit.common.Result;

public interface SkyTravelDriver extends AutoCloseable {
    /** Selects who subsequent operations are performed as. */
    void actAs(UserIdentity identity);

    Result<GoToSkyTravelResponse, SystemError> goToSkyTravel(GoToSkyTravelRequest request);

    Result<PlaceOrderResponse, SystemError> placeOrder(PlaceOrderRequest request);

    Result<CancelOrderResponse, SystemError> cancelOrder(CancelOrderRequest request);

    Result<DeliverOrderResponse, SystemError> deliverOrder(DeliverOrderRequest request);

    Result<ViewOrderResponse, SystemError> viewOrder(ViewOrderRequest request);

    Result<BrowseOrderHistoryResponse, SystemError> browseOrderHistory(BrowseOrderHistoryRequest request);

    Result<PublishCouponResponse, SystemError> publishCoupon(PublishCouponRequest request);

    Result<BrowseCouponsResponse, SystemError> browseCoupons(BrowseCouponsRequest request);
}
