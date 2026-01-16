package com.banking.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Baseclass {
    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public void capturescreenshots(String failTest) throws IOException {
        TakesScreenshot Ts = (TakesScreenshot) driver;
        File source = Ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + failTest + ".png";
        FileUtils.copyFile(source, new File(destination));
        System.out.println("Screenshot saves successfully");
    }

    @AfterMethod
    public void closebrowser(ITestResult result) throws IOException {
        System.out.println("Welcome to after method");
        if (result.getStatus() == ITestResult.FAILURE) {
            capturescreenshots(result.getName());
            System.out.println("Test Failed: Screenshot taken.");
        }
        driver.quit();
    }
}



