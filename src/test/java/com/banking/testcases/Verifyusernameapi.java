package com.banking.testcases;

import com.banking.base.Baseclass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.banking.base.Baseclass.driver;
import static io.restassured.RestAssured.given;

public class Verifyusernameapi extends Baseclass {
    @Test
    public void Verifyhybriddata(){
        String APIName = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .extract().path("name");
        System.out.println("API Name:" + APIName);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        boolean isNamePresent = driver.getPageSource().contains(APIName);
        System.out.println("Is Data Matched:" +isNamePresent);
        Assert.assertEquals(APIName,"Leanne Graham");

    }
}
