package com.utility;

public class CreateURL {

    public static final String BASE_URI = "https://api.github.com";

    public static String getBaseURI() {
        return BASE_URI;
    }

    public static String getBaseURI(String resourcePath) {
        return BASE_URI + resourcePath;
    }
}
