package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import pages.LoginPage;
import org.testng.Assert;
import utils.ConfigReader;
import utils.JsonReader;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);



@Given("user is on login page")
public void user_is_on_login_page() {
    driver.get(ConfigReader.getProperty("url"));
}

// @When("user enters username and password")
// public void user_enters_username_and_password() {
//     loginPage.enterUsername(ConfigReader.getProperty("username"));
//     loginPage.enterPassword(ConfigReader.getProperty("password"));
// }


@When("user enters username and password")
public void user_enters_username_and_password() {
    loginPage.enterUsername(JsonReader.getData("username"));
    loginPage.enterPassword(JsonReader.getData("password"));
}

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed");
    }
}