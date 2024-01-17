package com.moneypay.integration;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ResponseStatusTest extends BaseTest {
    @Test
    public void shouldStatusCheck() {
        Response response = given()
                .get(apiURL);

        int statusCode = response.getStatusCode();

        if (statusCode == 200) {
            System.out.println("Test Success - Http Status Code: 200");
        } else if (statusCode == 400) {
            System.out.println("Test Failed - Http Status Code:" + statusCode);
            Assert.fail("Test Failed - Http Status Code 400");
        } else {
            System.out.println("Unexpected Http Status Code: " + statusCode);
            Assert.fail("Test Failed - Unexpected Http Status Code");
        }
    }
}
