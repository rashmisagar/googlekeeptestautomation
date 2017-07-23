package com.test.automation.tests;


import com.test.automation.pages.LoginPage;
import com.test.automation.pages.HomePage;
import com.test.automation.testBase.GenerateRandomData;
import com.test.automation.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTest extends TestBase{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected LoginPage loginPage;
    GenerateRandomData generateRandomData;

    public static String browserType="firefox";
    public static String url="https://keep.google.com";
    public String emailAddress = "testabc12134@gmail.com";
    public String password = "testtest112233";


    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        driver = getDriver();
        driver = startBrowser(browserType);
        getUrl(url);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage.loginToGoogleAccount(emailAddress, password);
        generateRandomData = new GenerateRandomData();
    }

    @AfterClass
    public void endTest(){
       // closeBrowser();
    }
}



