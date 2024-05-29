package com.qa.flights.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final By emailid = By.id("email");
    private final By Password = By.cssSelector("input#password");
    private final By forgotLink = By.linkText("Forget Password");
    private final By loginButton = By.xpath("//button[@id='submit-btn-login']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginPageTitle() {
        String title = driver.getTitle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
        return title;
    }

    public boolean verifyForgotPwdLink() {
        return driver.findElement(forgotLink).isDisplayed();
    }

    public ItinerariesPage loginToApp(String email, String pwd) {
        driver.findElement(emailid).sendKeys(email);
        driver.findElement(Password).sendKeys(pwd);
        WebElement ele = driver.findElement(loginButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);
        return new ItinerariesPage(driver);
    }

}

