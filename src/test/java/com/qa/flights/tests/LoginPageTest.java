package com.qa.flights.tests;

import com.qa.flights.base.BaseTest;
import com.qa.flights.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeClass
    public void LoginPageSetUp() {
        loginPage = homepage.clickLoginLink();
    }

    @Test(priority = 1)
    public void getLoginPageTitleTest() {
        String text = loginPage.getLoginPageTitle();
        System.out.println(text);
        Assert.assertEquals(text, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void verifyForgotPwdLinkTest() {
        Assert.assertTrue(loginPage.verifyForgotPwdLink());
    }

    @Test(priority = 3)
    public void LoginToAppTest() {
        itinerariesPage = loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(itinerariesPage.getItinerariesTitle(), Constants.ITINERARIES_PAGE_TITLE);
    }


}
