package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase5 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P02_Login loginPage;
    P03_SignUp signupPage;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        loginPage = new P02_Login(driver, testData);
        signupPage = new P03_SignUp(driver, testData);
    }

    @Test
    public void testCaseFive(){
        homePage.navigateToHome().clickOnLoginButton();
        loginPage.verifyNewUserSignUp().fillSetup().clickSignUpButton();
        signupPage.verifyEmailAlreadyExists();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
