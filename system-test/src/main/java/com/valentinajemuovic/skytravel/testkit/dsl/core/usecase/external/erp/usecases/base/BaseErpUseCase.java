package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases.base;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.ErpDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.BaseUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;

public abstract class BaseErpUseCase<R, V> extends BaseUseCase<ErpDriver, R, V> {
    protected BaseErpUseCase(ErpDriver driver, UseCaseContext context) {
        super(driver, context);
    }
}
