package com.valentinajemuovic.skytravel.systemtest.legacy.mod05.smoke.external;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod05.base.BaseDriverTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.valentinajemuovic.skytravel.testkit.common.ResultAssert.assertThatResult;

class TaxSmokeTest extends BaseDriverTest {
    @BeforeEach
    void setUp() {
        setUpExternalDrivers();
    }

    @Test
    void shouldBeAbleToGoToTax() {
        var result = taxDriver.goToTax();
        assertThatResult(result).isSuccess();
    }
}
