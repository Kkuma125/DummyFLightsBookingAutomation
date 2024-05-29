package com.qa.flights.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItinerariesPage {

    private final WebDriver driver;
    private final By userDetails = By.xpath("//a[@id='dropdownMenuLink']");
    private final By backHome = By.xpath("//a[text()='Back to Home']/img");

    public ItinerariesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItinerariesTitle() {
        String title = driver.getTitle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
        return title;
    }

    public String userInfoDisplay() {
        WebElement ele = driver.findElement(userDetails);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(userDetails));
        return ele.getText().trim();

    }

    public void clickBack() {
        WebElement ele = driver.findElement(backHome);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(backHome));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);
        return;
    }

    public HomePage verifyBackToHome() {
        String title = driver.getTitle();
        System.out.println("We are Navigated to HomePage "+title);
        return new HomePage(driver);
    }
}
