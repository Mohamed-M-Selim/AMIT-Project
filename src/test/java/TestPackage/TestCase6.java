package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P06_ContactUs contactUsPage;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        contactUsPage = new P06_ContactUs(driver, testData);
    }

    @Test
    public void testCaseSix(){
        homePage.navigateToHome().clickOnContactUs();
        contactUsPage.verifyGetInTouch().fillContactForm().uploadFile()
                .clickOnSubmit().handleAlertClickOk().verifySuccessMessage()
                .clickOnHomeButton();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
