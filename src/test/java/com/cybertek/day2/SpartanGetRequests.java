package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanGetRequests {

    String baseUrl="http://44.201.152.160:8000";

//    Given Accept type application/json
//    When user GET request to api/spartans end point
//    Then Status code must be 200
//    response Content Type must be application/json
//    And response body should include spartan result



    @Test
    public void test1(){


                RestAssured. given().accept(ContentType.JSON)
                        .when().get(baseUrl + "/api/spartans")
                        .then().statusCode(200)
                        .contentType("application/json");



    }

    @DisplayName("Get spartan 3 and verify")
    @Test
    public void test2(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseUrl+ "/api/spartans/3");

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("application/json", response.contentType());
        Assertions.assertTrue(response.body().asString().contains("ece"));
        response.prettyPrint();

    }

    @Test
    public void test3(){

        Response response = RestAssured.when().get(baseUrl + "/api/hello");
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println("response.header(\"Date\") = " + response.header("Date"));

        Assertions.assertEquals("17", response.header("Content-Length"));
        Assertions.assertEquals("Hello from Sparta", response.body().asString());



    }

}
