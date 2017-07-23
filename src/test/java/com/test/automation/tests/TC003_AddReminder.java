package com.test.automation.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TC003_AddReminder extends BaseTest{

    public int remindersCount = 0;
    public String reminderTitle = "remind me today";

    @Test
    public void createANewReminder() throws InterruptedException {

        remindersCount = homePage.getRemindersCount();
        homePage.createNewReminder(reminderTitle);
        Assert.assertEquals(remindersCount + 1, homePage.getRemindersCount());

    }
}
