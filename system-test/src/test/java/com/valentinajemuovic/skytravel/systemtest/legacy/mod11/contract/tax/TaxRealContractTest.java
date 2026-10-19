package com.valentinajemuovic.skytravel.systemtest.legacy.mod11.contract.tax;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

class TaxRealContractTest extends BaseTaxContractTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}
