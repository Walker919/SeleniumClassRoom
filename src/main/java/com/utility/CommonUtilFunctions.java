package com.utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CommonUtilFunctions {

    public static JsonPath jsonPath;
    private static Logger log = Logger.getLogger(CommonUtilFunctions.class.getName());


    public static String getResponseKeyValue(String responseBody, String responseKey) {
        jsonPath = new JsonPath(responseBody);
        String keyValue = jsonPath.get(responseKey);

        return keyValue;
    }

    public static int getStatusCode(Response response) {
        int statusCode = response.getStatusCode();
        PropertyConfigurator.configure("log4j.properties");
        log.info("Status code: " + statusCode);
        return statusCode;
    }

    public static String getStatusMessage(Response response) {
        String statusMessage = response.getStatusLine();
        PropertyConfigurator.configure("log4j.properties");
        log.info("Status message: " + statusMessage);
        return statusMessage;
    }

    public static String getResponseHeader(Response response, String headerKey) {
        String responseHeader = response.getHeader(headerKey);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Response header: " + responseHeader);
        return responseHeader;
    }

    public static String getResponseContentType(Response response) {
        String contentType = response.getContentType();
        PropertyConfigurator.configure("log4j.properties");
        log.info("Response content type: " + contentType);
        return contentType;
    }
}
