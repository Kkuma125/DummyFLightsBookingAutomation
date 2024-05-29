package com.qa.flights.tests;

import com.qa.flights.base.BaseTest;
import com.qa.flights.utils.Constants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void getHomePageTitleTest() {
        String title = homepage.getHomePageTitle();
        System.out.println("HomePage Title is : "+title);
        Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void verifyLogoTest() {
        Assert.assertTrue(homepage.verifyLogo());
    }

    @Test(priority = 3)
    public void clickMenuTest() {
        homepage.clickMenu();
    }

    @Test(priority = 4)
    public void clickLoginLinkTest() {
        homepage.clickLoginLink();
    }

    @Test
    public void flightReservationDisplayorNotTest() {
        boolean display = homepage.flightReservationDisplayorNot();
        System.out.println(display);
    }

    @Test(priority = 5)
    public void clickFromTest() {
        homepage.clickFrom();
    }

    @Test(priority = 6)
    public void enterFromTest() {
        List<WebElement> text = homepage.enterFrom("New Delhi");
        System.out.println(text);
    }


}
