package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver(String browser) {

        if (driver.get() == null) {

            switch (browser.toLowerCase()) {
                case "chrome":

                    ChromeOptions options = new ChromeOptions();

                    // Add arguments
                    options.addArguments("--start-maximized");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-extensions");

                    // Headless mode (optional)
                    // options.addArguments("--headless=new");

                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser");
            }

            getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}