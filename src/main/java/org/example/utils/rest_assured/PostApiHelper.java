/*
 *
 * *****************************************************************************
 *  * Copyright ©2020 Mawdoo3. All rights reserved
 *  *  —————————————————————————————————
 *  *  NOTICE: All information contained herein is a property of Mawdoo3.
 *  *****************************************************************************
 *
 *
 */

package org.example.utils.rest_assured;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;

public class PostApiHelper {

    public static Response post(String apiUrl, JsonObject requestBody)  {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that().header("content-type", "application/json")
                    .body(requestBody.toString()).when().post(apiUrl).thenReturn();
        } else {
            try {
                throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
            } catch (InvalidResponseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Response getResponseByHeaders(String apiUrl, HashMap<String, String> headers) {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl))
            return RestAssured.given().that().headers(headers).when().post(apiUrl).thenReturn();
        Assert.fail(ApiConstants.INVALID_EMPTY_URL_ERROR);
        return null;
    }

    public static Response post(String apiUrl, File fileName) throws InvalidResponseException {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .body(fileName).when().post(apiUrl).thenReturn();
        } else {
            throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
        }
    }

    public static Response post(String apiUrl, HashMap<String, String> headers, JsonObject requestBody) throws InvalidResponseException {
        return post(apiUrl, headers, requestBody.toString());
    }

    public static Response post(String apiUrl, HashMap<String, String> headers, String requestBody)  {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .headers(headers)
                    .body(requestBody).when().post(apiUrl).thenReturn();
        } else {
            try {
                throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
            } catch (InvalidResponseException e) {
                e.printStackTrace();
            }
        }
    return null;
    }

    public static Response post(String apiUrl, HashMap<String, String> headers, File fileName) throws InvalidResponseException {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .headers(headers)
                    .body(fileName).when().post(apiUrl).thenReturn();
        } else {
            throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
        }
    }

    public static Response post(String apiUrl, HashMap<String, String> headers, HashMap<String, String> params) throws InvalidResponseException {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .headers(headers)
                    .params(params)
                    .when().post(apiUrl).thenReturn();
        } else {
            throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
        }
    }

    public static Response postResponseWithBasicAuth(String apiUrl, String body, HashMap<String, String> headers,
                                                     String username, String password) throws InvalidResponseException {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .body(body)
                    .headers(headers)
                    .auth().preemptive().basic(username, password)
                    .when().post(apiUrl).thenReturn();
        } else {
            throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
        }
    }

    public static Response post(String apiUrl, HashMap<String, String> params)  {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl)) {
            return RestAssured.given().that()
                    .params(params)
                    .when().post(apiUrl).thenReturn();
        } else {
            try {
                throw new InvalidResponseException(ApiConstants.INVALID_EMPTY_URL_ERROR);
            } catch (InvalidResponseException e) {
                e.printStackTrace();
            }
        }
    return null;
    }
}
