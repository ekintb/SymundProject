package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user")
    public WebElement userName;



    @FindBy(id="password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement submit;

    @FindBy(css=".warning.wrongPasswordMsg")
    public WebElement warningMessage;

    @FindBy(css=".toggle-password")
    public WebElement eyeButton;

    @FindBy(id="lost-password")
    public WebElement forgotPass;

    @FindBy(id="reset-password-submit")
    public WebElement resetButton;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }
}
