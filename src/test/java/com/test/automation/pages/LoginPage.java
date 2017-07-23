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

public class LoginPage extends TestBase {

    //Initialise objects in this page
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    Actions action;
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(id = "identifierId")
    WebElement loginEmailAddress;

    @FindBy(css = "#identifierNext > content > span")
    WebElement nextButtonEmail;

    @FindBy(name = "password")
    WebElement loginPassword;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
    WebElement nextButtonPass;


    public void loginToGoogleAccount(String emailAddress, String password) throws InterruptedException {
        action = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        loginEmailAddress.sendKeys(emailAddress);
        nextButtonEmail.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        loginPassword.sendKeys(password);
        action.moveToElement(nextButtonPass).perform();
        Thread.sleep(2000);
        action.click(nextButtonPass).perform();

    }

}
