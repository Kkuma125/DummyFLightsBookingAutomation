package com.qa.flights.tests;

import com.qa.flights.base.BaseTest;
import com.qa.flights.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ItinerariesPageTest extends BaseTest {

    @BeforeClass
    public void ItinerariesPageSetUp() {
        loginPage = homepage.clickLoginLink();
        itinerariesPage = loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void getItinerariesTitleTest() {
        String Title = itinerariesPage.getItinerariesTitle();
        System.out.println(Title);
        Assert.assertEquals(Title, Constants.ITINERARIES_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void userInfoDisplayTest() {
        String text = itinerariesPage.userInfoDisplay();
        Assert.assertEquals(text, "VINOD KUMAR");
    }

    @Test(priority = 3)
    public void clickBackTest() {
        itinerariesPage.clickBack();
    }

    @Test(priority = 4)
    public void verifyBackToHomeTest() {
        homepage = itinerariesPage.verifyBackToHome();
        Assert.assertEquals(homepage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }


}
