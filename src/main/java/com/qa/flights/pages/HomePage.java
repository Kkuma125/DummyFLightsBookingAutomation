package com.qa.flights.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    private final By menuLink = By.xpath("//button/img");

    private final By LoginLink = By.xpath("//a[text()='Login']");
    private final By isLogoExist = By.xpath("//div[@class='logo']/img");
    private final By clickfrom = By.xpath("//span[@id='select2-departure-city-container']");
    private final By flightDisplay = By.xpath("//a[normalize-space()='Flight Reservation']");
    private final By departureCity = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyLogo() {
        return driver.findElement(isLogoExist).isDisplayed();
    }

    public void clickMenu() {
        driver.findElement(menuLink).click();
    }

    public LoginPage clickLoginLink() {
        WebElement ele = driver.findElement(LoginLink);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginLink));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);
        return new LoginPage(driver);

    }

    public boolean flightReservationDisplayorNot() {
        return driver.findElement(flightDisplay).isDisplayed();
    }

    public void clickFrom() {
        WebElement ele = driver.findElement(clickfrom);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElements(ele));
        ele.click();
        return;
    }

    public List<WebElement> enterFrom(String FromCity) {
        List<WebElement> fromList = driver.findElements(departureCity);

        for (WebElement e : fromList) {
            String text = e.getText();
            System.out.println(text);
            e.sendKeys(FromCity);
            if (fromList.equals(FromCity)) {
                e.click();
                break;
            }
        }
        return fromList;
    }
}