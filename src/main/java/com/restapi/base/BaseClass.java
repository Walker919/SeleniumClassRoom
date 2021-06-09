package com.restapi.base;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {

    private static Logger log = Logger.getLogger(BaseClass.class.getName());

    public static Response getRequest(String requestUri) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.get(requestUri);
        log.info("Request response: " + response.getBody().asString());

        return response;
    }

    public static Response postRequest(String requestUri, String requestPayLoad) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        log.info("Request Payload: " + requestPayLoad);
        RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.post(requestUri);
        log.info("Request response: " + response.getBody().asString());

        return response;
    }

    public static Response postRequest(String requestUri, String requestPayLoad, String bearerToken) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        log.info("Request Payload: " + requestPayLoad);
        RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + bearerToken);
        Response response = requestSpecification.post(requestUri);
        log.info("Request response: " + response.getBody().asString());

        return response;
    }

    public static Response putRequest(String requestUri, String requestPayLoad) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        log.info("Request Payload: " + requestPayLoad);
        RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.put(requestUri);
        log.info("Request response: " + response.getBody().asString());

        return response;
    }

    public static Response deleteRequest(String requestUri) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(requestUri);
        log.info("Request status code: " + response.getStatusCode());

        return response;
    }

    public static Response deleteRequest(String requestUri, String bearerToken) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.header("Authorization", "Bearer " + bearerToken);
        Response response = requestSpecification.delete(requestUri);
        log.info("Request status code: " + response.getStatusCode());

        return response;
    }

    public static Response deleteRequestWithPayload(String requestUri, String requestPayLoad) {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Request URI: " + requestUri);
        log.info("Request payload: " + requestPayLoad);
        RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.delete(requestUri);
        log.info("Request status code: " + response.getStatusCode());

        return response;
    }

}