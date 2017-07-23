package com.test.automation.pages;

import com.test.automation.testBase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

    //Initialise objects in this page
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Actions action;

    private static int notesCount;
    private static int remindersCount;
    private static int labelsCount;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(xpath = "//*[@id='gbm:1']/a/span")
    WebElement notesBtnNav;

    @FindBy(xpath = "//li[@id='gbm:f']/a/span")
    WebElement createNewLabelBtnNav;

    @FindBy(xpath = "(//DIV[@contenteditable='true'])[2]")
    WebElement notesInput;

    @FindBy(xpath = "(//DIV[@role='button'][text()='Done'][text()='Done'])[1]")
    WebElement doneNotesBtn;

    @FindBy(css = "div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche")
    WebElement notesContainer;

    @FindBy(name = "q")
    WebElement searchNotesInput;

    @FindBy(css = "div.notranslate.IZ65Hb-YPqjbf.h1U9Be-YPqjbf.rTEl-SX9D7d-Y5a8lc")
    WebElement notesTitle;

    @FindBy(css = "body > div.VIpgJd-TUo6Hb.bF1uUb-sKfxWe.mQXP-BivLOc > div.mQXP-BivLOc-bN97Pc > div.mQXP-oKdM2c.mQXP-t0O6ic-oKdM2c.QQhtn > div.Q0hgme-LgbsSe.Q0hgme-Bz112c-LgbsSe.mQXP-lNLqSc-RmniWd.VIpgJd-LgbsSe")
    WebElement createNewLabelBtn;

    @FindBy(css = "body > div.VIpgJd-TUo6Hb.bF1uUb-sKfxWe.mQXP-BivLOc > div.mQXP-BivLOc-yePe5c > div")
    WebElement doneLabelBtn;

    @FindBy(className = "gb_nc")
    WebElement labelElements;

    @FindBy(css = "#gb > div.gb_ud.gb_Wd.gb_Zd > div.gb_rc.gb_Hd > div.gb_rc.gb_Kc.gb_2d > span")
    WebElement labelTitle;

    @FindBy(className = "neVct-Ne3sFf-fmcmS")
    WebElement noSearchResult;

    public String getPageURL() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='gbm:f']/a/span")));
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='gbm:f']/a/span")));
        return driver.getTitle();

    }

    public void goToNotesNav() {
        assertNotNull(notesBtnNav);
        notesBtnNav.click();
    }

    public void createNewNote(String noteTitle) throws InterruptedException {
        WebElement notesInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//DIV[@contenteditable='true'])[2]")));
        notesInput.sendKeys(noteTitle);
        wait.until(ExpectedConditions.elementToBeClickable(doneNotesBtn));
        doneNotesBtn.click();
    }

    public int getNotesCount() throws InterruptedException {
        if(driver.findElement(By.cssSelector("div.neVct-Ne3sFf-fmcmS")).isDisplayed())
            return 0;
        else{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche")));
            List<WebElement> noteContainers = driver.findElements(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche"));
            notesCount = noteContainers.size();
            return notesCount;
        }
    }

    public void goToRemindersNav() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gbm:2']/a/span"))).click();
    }

    public void createNewReminder(String reminderTitle) throws InterruptedException {
        goToRemindersNav();
        createNewNote(reminderTitle);
    }

    public int getRemindersCount() throws InterruptedException {
        goToRemindersNav();
        Thread.sleep(2000);
        if(driver.findElement(By.className("neVct-Ne3sFf-Bz112c")).isDisplayed())
            return 0;
        else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.notes-container.RfDI4d-sKfxWe > div.RfDI4d-bN97Pc.ogm-kpc > div.gkA7Yd-sKfxWe.ma6Yeb-r8s4j-gkA7Yd > div > div.IZ65Hb-n0tgWb.IZ65Hb-WsjYwc-nUpftc.di8rgd-r4nke.RNfche")));
            List<WebElement> reminderContainers = driver.findElements(By.cssSelector("body > div.notes-container.RfDI4d-sKfxWe > div.RfDI4d-bN97Pc.ogm-kpc > div.gkA7Yd-sKfxWe.ma6Yeb-r8s4j-gkA7Yd > div > div.IZ65Hb-n0tgWb.IZ65Hb-WsjYwc-nUpftc.di8rgd-r4nke.RNfche"));
            remindersCount = reminderContainers.size();
            return remindersCount;
        }

    }

    public void createNewLabel(String labelTitle) throws InterruptedException {
        action = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create new label"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//INPUT[@class='notranslate Q0hgme-y4JFTd AHmuwe-VtOx3e mQXP-YPqjbf'])[1]")))
                .sendKeys(labelTitle);
        action.moveToElement(doneLabelBtn).perform();
        Thread.sleep(2000);
        action.click(doneLabelBtn).perform();
    }

    public String getLabelTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#gb > div.gb_ud.gb_Wd.gb_Zd > div.gb_rc.gb_Hd > div.gb_rc.gb_Kc.gb_2d > span")));
        return labelTitle.getText();
    }

    public int getLabelsCount() throws InterruptedException {
        labelsCount = 0;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gb$:3")));
        List<WebElement> labels = driver.findElements(By.id("gb$:3"));
        labelsCount = labels.size();
        return labelsCount;
    }

    public void searchNoteTitle(String noteTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(searchNotesInput));
        searchNotesInput.sendKeys(noteTitle);
    }



    public boolean verifySearchResults() {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche")));
            //List<WebElement> notesContainers = driver.findElements(By.cssSelector("div.IZ65Hb-n0tgWb.di8rgd-r4nke.RNfche"));
            assertNotNull(notesContainer);
            return notesContainer.isDisplayed();
        }

    public String getFirstSearchNoteTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("G0jgYd-sn54Q")));
        return notesTitle.getText();
    }

    public String noSearchResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("neVct-Ne3sFf-fmcmS")));
        return noSearchResult.getText();
    }

}
