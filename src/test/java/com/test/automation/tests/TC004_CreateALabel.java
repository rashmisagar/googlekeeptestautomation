package com.test.automation.tests;

import org.testng.annotations.Test;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;


public class TC004_CreateALabel extends BaseTest{

    public int labelsCount;
    public String labelTitle = "test label";

    @Test
    public void createANewLabel() throws InterruptedException {

        labelsCount = homePage.getLabelsCount();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        labelTitle = labelTitle + generateRandomData.generateRandomString(10);
        homePage.createNewLabel(labelTitle);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Assert.assertEquals(labelsCount , homePage.getLabelsCount());

    }

}
