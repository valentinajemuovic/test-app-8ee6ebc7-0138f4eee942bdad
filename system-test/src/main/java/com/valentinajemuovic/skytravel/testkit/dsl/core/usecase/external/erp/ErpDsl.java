package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.ErpDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases.GetProduct;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases.GoToErp;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases.ReturnsProduct;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases.ReturnsPromotion;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;

public class ErpDsl implements AutoCloseable {
    protected final ErpDriver driver;
    protected final UseCaseContext context;

    public ErpDsl(ErpDriver driver, UseCaseContext context) {
        this.driver = driver;
        this.context = context;
    }

    @Override
    public void close() {
        Closer.close(driver);
    }

    public GoToErp goToErp() {
        return new GoToErp(driver, context);
    }

    public ReturnsProduct returnsProduct() {
        return new ReturnsProduct(driver, context);
    }

    public GetProduct getProduct() {
        return new GetProduct(driver, context);
    }

    public ReturnsPromotion returnsPromotion() {
        return new ReturnsPromotion(driver, context);
    }
}
