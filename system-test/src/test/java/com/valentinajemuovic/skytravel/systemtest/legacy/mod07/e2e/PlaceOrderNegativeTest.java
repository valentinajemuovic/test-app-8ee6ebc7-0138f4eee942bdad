package com.valentinajemuovic.skytravel.systemtest.legacy.mod07.e2e;

import com.valentinajemuovic.skytravel.testkit.channel.ChannelType;
import com.valentinajemuovic.skytravel.systemtest.legacy.mod07.e2e.base.BaseE2eTest;
import com.optivem.testing.Channel;
import org.junit.jupiter.api.TestTemplate;

import static com.valentinajemuovic.skytravel.systemtest.commons.constants.Defaults.*;

class PlaceOrderNegativeTest extends BaseE2eTest {
    @TestTemplate
    @Channel({ChannelType.UI, ChannelType.API})
    void shouldRejectOrderWithNonIntegerQuantity() {
        app.skyTravel().placeOrder().sku(SKU).quantity("3.5").country(COUNTRY).execute()
                .shouldFail()
                .errorMessage("The request contains one or more validation errors")
                .fieldErrorMessage("quantity", "Quantity must be an integer");
    }
}
