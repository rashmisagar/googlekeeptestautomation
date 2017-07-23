package com.test.automation.tests;

import org.testng.annotations.Test;
import org.junit.Assert;


public class TC002_CreateANote extends BaseTest{

    public int notesCount;
    public String noteTitle = "This is a test note";

    @Test
    public void createANewNote() throws InterruptedException {

        notesCount = homePage.getNotesCount();
        homePage.createNewNote(noteTitle);
        Assert.assertEquals(notesCount + 1, homePage.getNotesCount());

    }

}

