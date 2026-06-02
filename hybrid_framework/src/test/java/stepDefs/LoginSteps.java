package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
//import utils.JsonReader;
import utils.DriverManager;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get(ConfigReader.getProperty("url"));
    }

    // @When("user enters username and password")
    // public void user_enters_username_and_password() {
    // loginPage.enterUsername(ConfigReader.getProperty("username"));
    // loginPage.enterPassword(ConfigReader.getProperty("password"));
    // }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed");
    }
}