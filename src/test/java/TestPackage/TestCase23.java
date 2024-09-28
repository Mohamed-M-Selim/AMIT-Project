package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase23 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @Test
    public void testCase23() {
        new P01_Home(driver, testData).navigateToHome().clickOnLoginButton();
        new P02_Login(driver, testData).fillNameFieldSignup().fillEmailFieldSignup()
                .clickSignUpButton();
        new P03_SignUp(driver, testData).verifyEnterAccountInformation().selectTitleOne()
                .fillAccountInformation().newsletterCheckbox().offersCheckbox()
                .fillAddressInformation().clickCreateAccount();
        new P04_AccountCreated(driver, testData).verifyAccountCreated().clickContinueButton();
        new P01_Home(driver, testData).verifyLoggedInAs().addToCart().clickOnCartButton();
        new P10_CartPage(driver, testData).verifyCartPage().clickOnProceedToCheckout();
        new P12_Checkout(driver, testData).verifyAddressInformation().clickDeleteAccount();
        new P05_AccountDeleted(driver, testData).verifyAccountDeleted().clickContinueButton();

    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
