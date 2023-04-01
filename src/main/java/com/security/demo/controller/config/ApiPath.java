package com.security.demo.controller.config;

public final class ApiPath {

    private ApiPath() {
    }

    private static final String API_VERSION = "/api/v1";

    public static final String AUTHORITY_PATH = API_VERSION + "/permissions";
    public static final String USER_PATH = API_VERSION + "/users";
    public static final String ROLE_PATH = API_VERSION + "/roles";

}