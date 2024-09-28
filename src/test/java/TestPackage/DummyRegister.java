package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DummyRegister {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P02_Login loginPage;
    P03_SignUp signupPage;
    P04_AccountCreated accountCreatedPage;
    P05_AccountDeleted accountDeletedPage;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        loginPage = new P02_Login(driver, testData);
        signupPage = new P03_SignUp(driver, testData);
        accountCreatedPage = new P04_AccountCreated(driver, testData);
        accountDeletedPage = new P05_AccountDeleted(driver, testData);
    }

    @Test
    public void dummyRegister(){
        homePage.navigateToHome().clickOnLoginButton();
        //create an account to be able to log in
        loginPage.verifyNewUserSignUp().fillSetup().clickSignUpButton();
        signupPage.selectTitleOne().fillSignupSetup().newsletterCheckbox().offersCheckbox()
                .fillAddressInformation().clickCreateAccount();
        accountCreatedPage.verifyAccountCreated().clickContinueButton();
        homePage.clickOnLogoutButton();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
