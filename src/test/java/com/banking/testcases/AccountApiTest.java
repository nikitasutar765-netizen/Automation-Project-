package com.banking.testcases;

import com.github.dockerjava.transport.DockerHttpClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AccountApiTest {

    @Test
    public void getaccountdetails() {
       // RestAssured.baseURI = "https://parabank.parasoft.com/parabank/services/rest/v2";
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .header("Accept", "application/json")
                .when()
                //.get("/login/john/demo");
                .get("/users/1");

        System.out.println(response.asPrettyString());
        System.out.println("Status code:" + response.getStatusCode());

    }
}




