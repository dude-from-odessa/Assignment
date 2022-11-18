package utils;

import io.restassured.RestAssured;

public class APIConstants {

    public static final String BaseURI = RestAssured.baseURI = "https://waarkoop-server.herokuapp.com/api";
    public static final String SEARCH_ITEM = BaseURI + "/v1/search/test/";

}
