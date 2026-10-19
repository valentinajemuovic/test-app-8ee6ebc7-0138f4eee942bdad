package com.valentinajemuovic.skytravel.systemtest.legacy.mod11.contract.erp;

import com.valentinajemuovic.skytravel.testkit.dsl.port.ExternalSystemMode;

class ErpStubContractTest extends BaseErpContractTest {
    @Override
    protected ExternalSystemMode getFixedExternalSystemMode() {
        return ExternalSystemMode.STUB;
    }
}
