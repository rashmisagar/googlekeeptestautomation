package com.test.automation.tests;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class TC005_SearchNotes extends BaseTest{

    public String noteTitle = "test";


    @Test
    public void searchExistingNote() throws InterruptedException {

        homePage.searchNoteTitle(noteTitle);
        homePage.verifySearchResults();
        if(homePage.verifySearchResults())
            assertEquals(true, homePage.getFirstSearchNoteTitle().contains(noteTitle));
    }

    @Test
    public void searchNonExistingNote() throws InterruptedException {

        homePage.searchNoteTitle("teerewrw");
        homePage.verifySearchResults();
        if(!homePage.verifySearchResults())
            assertEquals(true, homePage.noSearchResults().contains("No matching results"));
    }
}


