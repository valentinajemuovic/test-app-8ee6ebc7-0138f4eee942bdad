package com.valentinajemuovic.skytravel.systemtest.latest.contract.tax;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

public class TaxRealContractTest extends BaseTaxContractTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}
