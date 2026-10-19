package com.valentinajemuovic.skytravel.systemtest.latest.contract.erp;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

class ErpRealContractTest extends BaseErpContractTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.REAL;
    }
}
