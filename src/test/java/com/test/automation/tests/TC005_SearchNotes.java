package com.test.automation.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class TC005_SearchNotes extends BaseTest{


    @Test
    public void searchExistingNote() throws InterruptedException {

        homePage.searchNoteTitle("test");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        homePage.verifySearchResults();
        assertEquals(true, homePage.getFirstSearchNoteTitle().contains("test"));
    }

    @Test
    public void searchNonExistingNote() throws InterruptedException {

        homePage.searchNoteTitle("teerewrw");
        homePage.verifySearchResults();
        if(!homePage.verifySearchResults())
            assertEquals(true, isTextPresent("No matching results"));
    }
}


