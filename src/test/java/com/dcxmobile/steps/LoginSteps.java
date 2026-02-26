package com.dcxmobile.steps;

import com.dcxmobile.config.KobitonConfig;
import com.dcxmobile.drivers.DriverFactory;
import com.dcxmobile.pages.HomePage;
import com.dcxmobile.pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private AppiumDriver driver;
    private LoginPage loginPage;
    private HomePage  homePage;

    @Given("I launch the Edward Jones app")
    public void i_launch_the_app() throws Exception {
        driver    = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage  = new HomePage(driver);
        System.out.println("  App launched on Kobiton device.");
    }

    @Given("I am logged in to the app")
    public void i_am_logged_in() throws Exception {
        i_launch_the_app();
        i_enter_valid_credentials();
        i_tap_next_button();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername(KobitonConfig.getAppUsername());
        loginPage.enterPassword(KobitonConfig.getAppPassword());
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter my password")
    public void i_enter_my_password() {
        loginPage.enterPassword(KobitonConfig.getAppPassword());
    }

    @And("I tap the Next button")
    public void i_tap_next_button() {
        loginPage.tapNextButton();
    }

    @Then("I should see the home screen with welcome message")
    public void i_should_see_home_screen() {
        assertThat(homePage.isHomeScreenVisible())
            .as("Home screen should be visible after login")
            .isTrue();
        System.out.println("  ✅ Home screen is visible!");
    }

    @Then("I should see the plus FAB button on home screen")
    public void i_should_see_fab_button() {
        assertThat(homePage.isFabButtonVisible())
            .as("FAB button should be visible on home screen")
            .isTrue();
        System.out.println("  ✅ FAB button is visible!");
    }

    @Then("I should see {string} section on home screen")
    public void i_should_see_section(String section) {
        assertThat(homePage.isDayAtGlanceVisible())
            .as(section + " should be visible")
            .isTrue();
        System.out.println("  ✅ " + section + " is visible!");
    }
}
