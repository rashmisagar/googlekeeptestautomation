package com.test.automation.pages;

import com.test.automation.testBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends TestBase{

    //Initialise objects in this page
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    Actions action;
    private WebDriverWait wait = new WebDriverWait(driver, 30);
/*
    private String emailAddress = "testabc12134@gmail.com";
    private String password = "testtest112233";

    private WebDriverWait wait = new WebDriverWait(driver, 40);

    By loginEmailAddress = By.id("identifierId");

    By nextButtonEmail = By.cssSelector("#identifierNext > content > span");

    By loginPassword = By.xpath("//INPUT[@type='password']");

    By nextButtonPass = By.cssSelector("#passwordNext > content > span");

*/

    @FindBy(id="identifierId")
    WebElement loginEmailAddress;

    @FindBy(css="#identifierNext > content > span")
    WebElement nextButtonEmail;

    @FindBy(name="password")
    WebElement loginPassword;

    @FindBy(xpath="//*[@id=\"passwordNext\"]/content/span")
    WebElement nextButtonPass;


    public void loginToGoogleAccount(String emailAddress, String password) throws InterruptedException {
        action = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        //enterEmailAddressToLogin(emailAddress);
        loginEmailAddress.sendKeys(emailAddress);
        nextButtonEmail.click();
        //clickNextBtnEmail();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        loginPassword.sendKeys(password);
        action.moveToElement(nextButtonPass).perform();
        Thread.sleep(2000);
        action.click(nextButtonPass).perform();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/content/span")));
        //nextButtonPass.click();
        //enterPasswordToLogin(password);
        //clickNextBtnPassword();
    }

    public void enterEmailAddressToLogin(String emailAddress){
        loginEmailAddress.isDisplayed();
        loginEmailAddress.sendKeys(emailAddress);
    }


    public void clickNextBtnEmail(){
        nextButtonEmail.click();
    }

    public void enterPasswordToLogin(String password){
        loginPassword.sendKeys(password);
    }

    public void clickNextBtnPassword(){
        nextButtonPass.click();
    }

}

