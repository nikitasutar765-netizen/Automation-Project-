package com.banking.pages;

import com.banking.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Baseclass {
    @FindBy(name="username")
    WebElement Username;

    @FindBy(name ="password")
    WebElement Password;

    @FindBy(xpath ="//input[@value='Log In']")
    WebElement Loginbutton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String un) {
        Username.sendKeys(un);
    }
    public void setPassword(String pwd) {
        Password.sendKeys(pwd);
    }

    public void setLoginbutton() {
        Loginbutton.click();
    }
}
