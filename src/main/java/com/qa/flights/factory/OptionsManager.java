package com.qa.flights.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(OptionsManager.class));

    private final Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        LOGGER.info("getting Chrome Options");
        co = new ChromeOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
        if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
        return co;
    }

    public FirefoxOptions getFirefoxOptions() {
        LOGGER.info("getting Firefox Options");
        fo = new FirefoxOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless").trim())) fo.addArguments("--headless");
        if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) fo.addArguments("--incognito");
        return fo;
    }
}
