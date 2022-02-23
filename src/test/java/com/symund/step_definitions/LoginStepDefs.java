package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() throws InterruptedException {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.waitFor(5);
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("https://qa.symund.com/index.php/apps/dashboard/", actualUrl);

    }

    @When("the user enters invalid username")
    public void the_user_enters_invalid_username() {
        String username = ConfigurationReader.get("invalid_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the user should see warning message")
    public void the_user_should_see_warning_message() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage = new LoginPage();
        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals("Kullanıcı adı ya da parola hatalı.", actualMessage);

    }

    @When("the user enters invalid password")
    public void the_user_enters_invalid_password() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("invalid_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @When("the user clicks login button")
    public void the_user_clicks_login_button() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage = new LoginPage();
        loginPage.submit.click();

    }
    @Then("the user should see popup message")
    public void the_user_should_see_popup_message() {
    LoginPage loginPage=new LoginPage();
    String popUp = loginPage.userName.getAttribute("validationMessage");
        Assert.assertEquals("Lütfen bu alanı doldurun.", popUp);

    }


        @Then("the user can see the password in a form of dots by default")
        public void the_user_can_see_the_password_in_a_form_of_dots_by_default() {
            BrowserUtils.waitFor(3);
            LoginPage loginPage = new LoginPage();
            String dotPassword  = loginPage.password.getAttribute("type");
            Assert.assertEquals("password", dotPassword);

        }

        @Then("the user clicks eye button")
        public void the_user_clicks_eye_button() {
            BrowserUtils.waitFor(3);
            LoginPage loginPage=new LoginPage();
            loginPage.eyeButton.click();

        }

        @Then("the user can see the password explicitly")
        public void he_user_can_see_the_password_explicitly() {
            BrowserUtils.waitFor(3);
            LoginPage loginPage=new LoginPage();
            String dotPassword  = loginPage.password.getAttribute("type");

            Assert.assertEquals("text", dotPassword);
        }

    @Then("the user can see the forgot password link")
    public void the_user_can_see_the_forgot_password_link() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage=new LoginPage();
        Assert.assertEquals("Parolamı unuttum", loginPage.forgotPass.getText());
    }

    @When("the user clicks forgot password link")
    public void the_user_clicks_forgot_password_link() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage=new LoginPage();
        loginPage.forgotPass.click();
    }

    @Then("the user can see the reset password button")
    public void the_user_can_see_the_reset_password_button() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage=new LoginPage();
        Assert.assertEquals("Parolayı sıfırla", loginPage.resetButton.getAttribute("value"));
    }

    @Then("the user can see Username or email as placeholder")
    public void the_user_can_see_Username_or_email_as_placeholder() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage=new LoginPage();
        Assert.assertEquals("Kullanıcı adı ya da e-posta", loginPage.userName.getAttribute("placeholder"));
    }

    @Then("the user can see Password as placeholder")
    public void the_user_can_see_Password_as_placeholder() {
        BrowserUtils.waitFor(3);
        LoginPage loginPage=new LoginPage();
        Assert.assertEquals("Parola", loginPage.password.getAttribute("placeholder"));

    }


}

