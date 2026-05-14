package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        String browser=ConfigReader.getProperty("browser");
        DriverManager.getDriver(browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}