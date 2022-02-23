package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefs {
    @When("the user clicks the avatar")
    public void the_user_clicks_the_avatar() {
        BrowserUtils.waitFor(3);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.avatar.click();

    }



    @When("the user clicks logout button")
    public void the_user_clicks_logout_button() {
        BrowserUtils.waitFor(3);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.logout.click();
    }

    @Then("the user should be able to logout")
    public void the_user_should_be_able_to_logout() {
        BrowserUtils.waitFor(5);
        String actualUrl2 = Driver.get().getCurrentUrl();
        Assert.assertEquals("https://qa.symund.com/index.php/login?clear=1", actualUrl2);

    }

    @When("the user clicks back button")
    public void the_user_clicks_back_button() {
        BrowserUtils.waitFor(3);
        Driver.get().navigate().back();


    }

    @Then("the user is still on the same page")
    public void the_user_is_still_on_the_same_page() {
        BrowserUtils.waitFor(3);
        String actualUrl3 = Driver.get().getCurrentUrl();
        Assert.assertEquals("https://qa.symund.com/index.php/login?redirect_url=/index.php/apps/dashboard/", actualUrl3);
    }
}