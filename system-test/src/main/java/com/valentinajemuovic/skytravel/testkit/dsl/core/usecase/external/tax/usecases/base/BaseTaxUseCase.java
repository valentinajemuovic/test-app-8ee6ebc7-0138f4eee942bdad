package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.tax.usecases.base;

import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.BaseUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.TaxDriver;

public abstract class BaseTaxUseCase<R, V> extends BaseUseCase<TaxDriver, R, V> {
    protected BaseTaxUseCase(TaxDriver driver, UseCaseContext context) {
        super(driver, context);
    }
}
