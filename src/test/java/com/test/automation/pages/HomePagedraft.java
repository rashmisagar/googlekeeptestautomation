package com.test.automation.pages;

import com.test.automation.testBase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import com.test.automation.testBase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePagedraft extends TestBase {

    //Initialise objects in this page
    public HomePagedraft(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait wait = new WebDriverWait(driver, 40);
    private static int labelCount;
    private static int noteCount;

    @FindBy(xpath="//li[@id='gbm:f']/a/span")
    WebElement createNewLabelBtnNav;

    @FindBy(xpath="(//DIV[@contenteditable='true'])[2]")
    WebElement notesBtn;

    @FindBy(xpath="(//DIV[@role='button'][text()='Done'][text()='Done'])[1]")
    WebElement doneNotesBtn;

    @FindBy(xpath="//INPUT[@class='gb_Fe']")
    WebElement searchNotesField;

    @FindBy(css="div.Q0hgme-LgbsSe.Q0hgme-fmcmS-LgbsSe.mQXP-BivLOc-iib5kc.VIpgJd-LgbsSe")
    WebElement doneLabelBtn;

    @FindBy(className="gb_nc")
    WebElement labelElements;

    @FindBy(xpath="#gb > div.gb_ud.gb_Wd.gb_Xd > div.gb_rc.gb_Hd > div:nth-child(1) > svg")
    WebElement archiveNoteBtn;

    @FindBy(xpath="//INPUT[@class='gb_Fe']")
    WebElement archiveBtnNav;

    @FindBy(xpath="//INPUT[@class='gb_Fe']")
    WebElement deleteNoteBtn;

    @FindBy(xpath="//INPUT[@class='gb_Fe']")
    WebElement deleteBtnNav;



    public String getPageURL() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='gbm:f']/a/span")));
        return driver.getCurrentUrl();
    }

    public void createNewNote() throws InterruptedException {
        WebElement notesBtnNav = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//DIV[@contenteditable='true'])[2]")));
        notesBtnNav.sendKeys("This is the first test note");
        Thread.sleep(3000);
        doneNotesBtn.click();
    }

    public void verifyNewNoteCreated() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche")));
        List<WebElement> noteBoxes = driver.findElements(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche"));
        int noteAmount = noteBoxes.size();
        System.out.println(noteAmount);
        int expectedAmount =  noteCount + 1;
        System.out.println(expectedAmount);
        Assert.assertTrue(noteAmount == expectedAmount);
    }

    public void searchNoteTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@class='gb_Fe']"))).sendKeys("New Note");
    }

    public void verifyNoteSearchResult() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche")));
        List<WebElement> noteBoxes = driver.findElements(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche"));
        Assert.assertTrue(!noteBoxes.isEmpty());
    }

    public void searchNonExistentNote() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//INPUT[@class='gb_Fe']"))).sendKeys("Good Morning");
    }

    public void verifyNoSearchResult() throws InterruptedException {
        WebElement noResults = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("neVct-Ne3sFf-fmcmS")));
        System.out.println(noResults.getText());
        Thread.sleep(2000);
        Assert.assertTrue(noResults.getText().equals("No matching results."));

    }

    public void addNewLabel() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create new label"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//INPUT[@class='notranslate Q0hgme-y4JFTd AHmuwe-VtOx3e mQXP-YPqjbf'])[1]")))
                .sendKeys("New Label");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.Q0hgme-LgbsSe.Q0hgme-fmcmS-LgbsSe.mQXP-BivLOc-iib5kc.VIpgJd-LgbsSe")).click();


    }
    public void verifyLabelCreated() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("gb_nc")));
        List<WebElement> labelElements = driver.findElements(By.className("gb_nc"));
        ArrayList<String> labels = new ArrayList<String>();
        for (WebElement label: labelElements) {
            labels.add(label.getText());
        }
        System.out.println(labels);
        int labelAmount = labels.size();
        System.out.println(labelAmount);
        int expectedAmount =  labelCount + 1;
        System.out.println(expectedAmount);
        Assert.assertTrue(labelAmount == expectedAmount);

    }

    public void archiveNote() {
        WebElement sideMenu =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#gb > div.gb_ud.gb_Wd.gb_Xd > div.gb_rc.gb_Hd > div:nth-child(1) > svg")));
        clickArchiveButton();
    }

    public void clickArchiveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.gb_rc.gb_Hd > div:first-child > svg"))).click();
    }

    public void verifyArchivedNote() {
        List<WebElement> menu = driver.findElements(By.cssSelector("div.gb_me.gb_cc gb_dc gb_vd.gb_g"));
        System.out.println(menu.size());
        Assert.assertTrue(menu.size() == 0);
    }


    public void deleteNote() {
        WebElement sideMenu =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#gb > div.gb_ud.gb_Wd.gb_Xd > div.gb_rc.gb_Hd > div:nth-child(1) > svg")));
        clickDeleteNoteButton();
    }

    public void clickDeleteNoteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.gb_rc.gb_Hd > div:first-child > svg"))).click();
    }

    public void verifyDeletedNoteInBin() {
        List<WebElement> menu = driver.findElements(By.cssSelector("div.gb_me.gb_cc gb_dc gb_vd.gb_g"));
        System.out.println(menu.size());
        Assert.assertTrue(menu.size() == 0);
    }

    public void getCountOfNotes() throws InterruptedException {
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche"))));
        List<WebElement> notes = driver.findElements(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche"));
        noteCount = notes.size();
        System.out.println(notes.size());
    }

    public void getCountOfLabels() throws InterruptedException {
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.gb_nc"))));
        List<WebElement> labels = driver.findElements(By.cssSelector("span.gb_nc"));
        labelCount = labels.size();
        System.out.println(labels.size());
    }
}

