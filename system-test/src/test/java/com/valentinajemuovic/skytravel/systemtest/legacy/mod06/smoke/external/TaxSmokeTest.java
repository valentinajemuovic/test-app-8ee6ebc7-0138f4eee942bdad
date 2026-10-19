package com.valentinajemuovic.skytravel.systemtest.legacy.mod06.smoke.external;

import com.valentinajemuovic.skytravel.systemtest.legacy.mod06.base.BaseChannelDriverTest;
import org.junit.jupiter.api.Test;

import static com.valentinajemuovic.skytravel.testkit.common.ResultAssert.assertThatResult;

class TaxSmokeTest extends BaseChannelDriverTest {
    @Test
    void shouldBeAbleToGoToTax() {
        var result = taxDriver.goToTax();
        assertThatResult(result).isSuccess();
    }
}
