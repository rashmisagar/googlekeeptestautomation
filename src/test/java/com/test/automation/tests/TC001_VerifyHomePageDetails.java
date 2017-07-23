package com.test.automation.tests;


import org.testng.annotations.Test;
import org.junit.Assert;



public class TC001_VerifyHomePageDetails extends BaseTest {

    public String pageURL="https://keep.google.com";
    public String pageTitle="Google Keep";

    @Test
    public void verifyLoginWithValidCredentials() throws InterruptedException {

        Assert.assertEquals(true, homePage.getPageURL().contains(pageURL));
        Assert.assertEquals(true, homePage.getPageTitle().contains(pageTitle));

    }


}
