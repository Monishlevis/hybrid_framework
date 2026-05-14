package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import java.time.Duration;
import utils.WaitHelper;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");

    // Actions (methods)


public void enterUsername(String user) {
    WaitHelper.waitForElementVisible(driver, username);
    driver.findElement(username).sendKeys(user);
}

public void enterPassword(String pass) {
    WaitHelper.waitForElementVisible(driver, password);
    driver.findElement(password).sendKeys(pass);
}

public void clickLogin() {
    WaitHelper.waitForElementClickable(driver, loginBtn);
    driver.findElement(loginBtn).click();
}

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}