package com.valentinajemuovic.skytravel.testkit.dsl.core.usecase.external.tax.usecases;

import com.valentinajemuovic.skytravel.testkit.common.Converter;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.ResponseVerification;
import com.valentinajemuovic.skytravel.testkit.dsl.core.shared.UseCaseContext;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.dtos.GetTaxResponse;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class GetTaxVerification extends ResponseVerification<GetTaxResponse> {
    public GetTaxVerification(GetTaxResponse response, UseCaseContext context) {
        super(response, context);
    }

    public GetTaxVerification country(String expectedCountryAlias) {
        var expectedCountry = getContext().getParamValueOrLiteral(expectedCountryAlias);
        var actualCountry = getResponse().getCountry();
        assertThat(actualCountry)
                .withFailMessage("Expected country to be '%s', but was '%s'", expectedCountryAlias, actualCountry)
                .isEqualTo(expectedCountry);
        return this;
    }

    public GetTaxVerification taxRate(BigDecimal expectedTaxRate) {
        var actualTaxRate = getResponse().getTaxRate();
        assertThat(actualTaxRate)
                .withFailMessage("Expected tax rate to be %s, but was %s", expectedTaxRate, actualTaxRate)
                .isEqualByComparingTo(expectedTaxRate);
        return this;
    }

    public GetTaxVerification taxRate(double expectedTaxRate) {
        return taxRate(Converter.toBigDecimal(expectedTaxRate));
    }

    public GetTaxVerification taxRate(String expectedTaxRate) {
        return taxRate(Converter.toBigDecimal(expectedTaxRate));
    }

    public GetTaxVerification taxRateIsPositive() {
        var actualTaxRate = getResponse().getTaxRate();
        assertThat(actualTaxRate)
                .withFailMessage("Expected tax rate to be positive, but was %s", actualTaxRate)
                .isPositive();
        return this;
    }
}
