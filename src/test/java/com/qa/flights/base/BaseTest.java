package com.qa.flights.base;

import com.qa.flights.factory.DriverFactory;
import com.qa.flights.pages.HomePage;
import com.qa.flights.pages.ItinerariesPage;
import com.qa.flights.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    public DriverFactory df;
    public HomePage homepage;
    public LoginPage loginPage;
    public ItinerariesPage itinerariesPage;
    public Properties prop;
    public WebDriver driver;

    @Parameters({"Browser", "version"})
    @BeforeTest
    public void setUp(String browserName, String browserVersion) {
        df = new DriverFactory();
        prop = df.init_prop();
        String browser = prop.getProperty("Browser");

        if (browserName!=null) {
            browser = browserName;
        }

        driver = df.init_driver(browser, browserVersion);
        driver.get(prop.getProperty("url"));
        homepage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }

}
