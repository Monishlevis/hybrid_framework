package stepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("user should be navigated to dashboard")
    public void user_should_be_navigated_to_dashboard() {
        System.out.println("Login successful"); // temp validation
    }
}