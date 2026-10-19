package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.PublishCouponRequest;
import com.valentinajemuovic.skytravel.testkit.driver.port.SkyTravelDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.usecases.base.BaseSkyTravelUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;

public class PublishCoupon extends BaseSkyTravelUseCase<Void, VoidVerification> {
    private String couponCodeParamAlias;
    private String discountRate;
    private String validFrom;
    private String validTo;
    private String usageLimit;

    public PublishCoupon(SkyTravelDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    public PublishCoupon couponCode(String couponCodeParamAlias) {
        this.couponCodeParamAlias = couponCodeParamAlias;
        return this;
    }

    public PublishCoupon discountRate(String discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    public PublishCoupon validFrom(String validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public PublishCoupon validTo(String validTo) {
        this.validTo = validTo;
        return this;
    }

    public PublishCoupon usageLimit(String usageLimit) {
        this.usageLimit = usageLimit;
        return this;
    }

    @Override
    public UseCaseResult<Void, VoidVerification> execute() {
        var couponCode = context.getParamValue(couponCodeParamAlias);

        var request = PublishCouponRequest.builder()
                .code(couponCode)
                .discountRate(discountRate)
                .validFrom(validFrom)
                .validTo(validTo)
                .usageLimit(usageLimit)
                .build();

        var result = driver.publishCoupon(request).mapVoid();
        return new UseCaseResult<>(result, context, VoidVerification::new);
    }
}
