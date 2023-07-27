package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {

    @BeforeAll
    public static void init() {
        baseURI = "http://44.201.152.160:1000/ords/hr";
    }

    @Test
    public void test1(){

        Response response = get("/regions");

    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/regions/2");


        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        assertTrue(response.body().asString().contains("Americas"));




    }

}
