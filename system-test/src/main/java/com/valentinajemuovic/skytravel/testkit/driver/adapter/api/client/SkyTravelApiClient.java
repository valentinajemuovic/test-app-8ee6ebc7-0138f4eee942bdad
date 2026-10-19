package com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client;

import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client.controllers.CouponController;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client.controllers.HealthController;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client.controllers.OrderController;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.api.client.dtos.errors.ProblemDetailResponse;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.shared.client.http.JsonHttpClient;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.shared.client.http.KeycloakTokenProvider;
import com.valentinajemuovic.skytravel.testkit.driver.adapter.shared.client.http.TestUser;
import com.valentinajemuovic.skytravel.testkit.common.Closer;

public class SkyTravelApiClient implements AutoCloseable {
    private final JsonHttpClient<ProblemDetailResponse> httpClient;
    private final HealthController healthController;
    private final OrderController orderController;
    private final CouponController couponController;
    private final KeycloakTokenProvider tokenProvider;
    private volatile ApiIdentity identity = ApiIdentity.DEFAULT;
    private volatile TestUser customer = TestUser.CUSTOMER;

    public SkyTravelApiClient(String baseUrl) {
        this(baseUrl, null);
    }

    /**
     * @param keycloakBaseUrl when null or blank, no token is acquired and no Authorization header is sent.
     */
    public SkyTravelApiClient(String baseUrl, String keycloakBaseUrl) {
        this.httpClient = new JsonHttpClient<>(baseUrl, ProblemDetailResponse.class);
        this.healthController = new HealthController(httpClient);
        this.orderController = new OrderController(httpClient);
        this.couponController = new CouponController(httpClient);
        if (keycloakBaseUrl != null && !keycloakBaseUrl.isBlank()) {
            this.tokenProvider = KeycloakTokenProvider.forBaseUrl(keycloakBaseUrl);
            this.httpClient.setBearerTokenSource(this::tokenFor);
        } else {
            this.tokenProvider = null;
        }
    }

    public SkyTravelApiClient as(ApiIdentity identity) {
        this.identity = identity;
        return this;
    }

    /** Calls are made as the given customer, until changed again. */
    public SkyTravelApiClient asCustomer(TestUser customer) {
        this.identity = ApiIdentity.CUSTOMER;
        this.customer = customer;
        return this;
    }

    public HealthController health() {
        return healthController;
    }

    public OrderController orders() {
        return orderController;
    }

    public CouponController coupons() {
        return couponController;
    }

    @Override
    public void close() {
        Closer.close(httpClient);
    }

    private String tokenFor(String method, String path) {
        return switch (identity) {
            case ANONYMOUS -> null;
            case CUSTOMER -> tokenProvider.getToken(customer);
            case ADMIN -> tokenProvider.getToken(TestUser.ADMIN);
            case DEFAULT -> tokenProvider.getToken(isAdminOnly(method, path) ? TestUser.ADMIN : TestUser.CUSTOMER);
        };
    }

    private static boolean isAdminOnly(String method, String path) {
        if (path.startsWith("/api/admin/")) {
            return true;
        }
        if (path.equals("/api/coupons") && ("POST".equals(method) || "GET".equals(method))) {
            return true;
        }
        return "POST".equals(method) && path.startsWith("/api/orders/") && path.endsWith("/deliver");
    }
}
