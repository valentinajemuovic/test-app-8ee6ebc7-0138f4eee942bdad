package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase;

import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.driver.port.UserIdentity;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.BrowseCoupons;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.BrowseOrderHistory;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.CancelOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.DeliverOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.GoToSkyTravel;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.PlaceOrder;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.PublishCoupon;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.ViewOrder;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;

import java.io.Closeable;

public class SkyTravelDsl implements Closeable {
    private final SkyTravelDriver driver;
    private final UseCaseContext context;

    public SkyTravelDsl(SkyTravelDriver driver, UseCaseContext context) {
        this.driver = driver;
        this.context = context;
    }

    @Override
    public void close() {
        Closer.close(driver);
    }

    public void actAs(UserIdentity identity) {
        driver.actAs(identity);
    }

    public GoToSkyTravel goToSkyTravel() {
        return new GoToSkyTravel(driver, context);
    }

    public PlaceOrder placeOrder() {
        return new PlaceOrder(driver, context);
    }

    public CancelOrder cancelOrder() {
        return new CancelOrder(driver, context);
    }

    public DeliverOrder deliverOrder() {
        return new DeliverOrder(driver, context);
    }

    public ViewOrder viewOrder() {
        return new ViewOrder(driver, context);
    }

    public BrowseOrderHistory browseOrderHistory() {
        return new BrowseOrderHistory(driver, context);
    }

    public PublishCoupon publishCoupon() {
        return new PublishCoupon(driver, context);
    }

    public BrowseCoupons browseCoupons() {
        return new BrowseCoupons(driver, context);
    }
}
