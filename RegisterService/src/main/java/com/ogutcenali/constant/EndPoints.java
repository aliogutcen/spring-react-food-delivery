package com.ogutcenali.constant;

public class EndPoints {
    public static final String VERSION = "/v1";
    public static final String API = "/api";
    public static final String USER_REGISTER= API + VERSION + "/user-register";
    public static final String RESTAURANT_REGISTER= API + VERSION + "/restaurant-register";

    //   ACCEPT_RESTAURANT START
    public static final String ACCPET_RESTAURANT= API + VERSION + "/accept_restaurant";

    public static final String GET_ALL_APPROVAL= API + VERSION +ACCPET_RESTAURANT +"/getall";
    //   ACCEPT_RESTAURANT END
    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String ACTIVATE = "/activate";
    public static final String LOGIN = "/login";



}
