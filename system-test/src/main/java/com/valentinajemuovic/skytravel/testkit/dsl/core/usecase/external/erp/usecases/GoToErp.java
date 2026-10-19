package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.erp.ErpDriver;
import com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.erp.usecases.base.BaseErpUseCase;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseResult;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.VoidVerification;
import com.valentinajemuovic.skytravel.testkit.driver.port.dtos.error.SystemError;

public class GoToErp extends BaseErpUseCase<Void, VoidVerification> {
    public GoToErp(ErpDriver driver, UseCaseContext context) {
        super(driver, context);
    }

    @Override
    public UseCaseResult<Void, VoidVerification> execute() {
        var result = driver.goToErp();
        return new UseCaseResult<>(result.mapError(e -> SystemError.of(e.getMessage())), context, VoidVerification::new);
    }
}
