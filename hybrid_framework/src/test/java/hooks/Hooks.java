package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverManager;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        DriverManager.initDriver(browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}