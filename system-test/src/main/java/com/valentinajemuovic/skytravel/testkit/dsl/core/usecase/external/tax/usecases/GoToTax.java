package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.tax.usecases;

import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.error.SystemError;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.tax.usecases.base.BaseTaxUseCase;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.TaxDriver;

public class GoToTax extends BaseTaxUseCase<Void, VoidVerification> {
    public GoToTax(TaxDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    @Override
    public UseCaseResult<Void, VoidVerification> execute() {
        var result = driver.goToTax();
        return new UseCaseResult<>(result.mapError(e -> SystemError.of(e.getMessage())), context, VoidVerification::new);
    }
}
