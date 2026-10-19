package com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax;

import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.TaxDriver;

import com.valentinajemuovic.skytravel.testkit.driver.adapter.external.tax.client.BaseTaxClient;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.dtos.GetTaxResponse;
import com.valentinajemuovic.skytravel.testkit.driver.port.external.tax.dtos.error.TaxErrorResponse;
import com.valentinajemuovic.skytravel.testkit.common.Closer;
import com.valentinajemuovic.skytravel.testkit.common.Result;

public abstract class BaseTaxDriver<C extends BaseTaxClient> implements TaxDriver {
    protected final C client;

    protected BaseTaxDriver(C client) {
        this.client = client;
    }

    @Override
    public void close() {
        Closer.close(client);
    }

    @Override
    public Result<Void, TaxErrorResponse> goToTax() {
        return client.checkHealth()
                .mapError(ext -> new TaxErrorResponse(ext.getMessage()));
    }

    @Override
    public Result<GetTaxResponse, TaxErrorResponse> getTaxRate(String country) {
        return client.getCountry(country)
                .map(taxRateResponse -> GetTaxResponse.builder()
                        .country(taxRateResponse.getId())
                        .taxRate(taxRateResponse.getTaxRate())
                        .build())
                .mapError(ext -> new TaxErrorResponse(ext.getMessage()));
    }
}
