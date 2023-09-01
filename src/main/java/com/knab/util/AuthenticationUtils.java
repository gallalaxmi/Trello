package com.knab.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class AuthenticationUtils {

    private static final String BASE_URL_API = EnvironmentSetup.BASE_URL_API;
    private static final String API_KEY = EnvironmentSetup.API_KEY;
    private static final String API_TOKEN = EnvironmentSetup.API_TOKEN;
    private static final String KEY = "key";
    private static final String TOKEN = "token";

    /**
     * Constructor for AuthenticationUtils.
     */
    private AuthenticationUtils() {

    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API)
                .contentType(ContentType.JSON.toString())
                .queryParam(KEY, API_KEY)
                .queryParam(TOKEN, API_TOKEN);
        return request;
    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getNotLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API);
        return request;
    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getNotLoggedWithKeyReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API)
                .contentType(ContentType.JSON.toString())
                .queryParam(KEY, API_KEY);
        return request;
    }

    /**
     * Get request specifications.
     *
     * @return request.
     */
    public static RequestSpecification getNotLoggedWithTokenReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL_API)
                .contentType(ContentType.JSON.toString())
                .queryParam(TOKEN, API_TOKEN);
        return request;
    }
}


