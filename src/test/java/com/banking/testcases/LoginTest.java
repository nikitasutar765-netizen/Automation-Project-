package com.banking.testcases;

import com.banking.base.Baseclass;
import com.banking.pages.LoginPage;
import com.banking.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.annotation.Native;

public class LoginTest extends Baseclass {
   // @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        System.out.println("Page title is:"+title);
        if (title.contains("ParaBank")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }

   // @Test
    public void LoginTest(){
        LoginPage Lp = new LoginPage();
        Lp.setUsername("john");
        Lp.setPassword("demo");
        Lp.setLoginbutton();
        System.out.println("Login Page Completed");
    }

    //@Test
    public void bankLogin(){
        String user = ExcelUtils.getdata(1,0);
        String pass = ExcelUtils.getdata(1,1);

       // WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        System.out.println("Login Successful with: " + user);
//driver.quit();

    }
}
