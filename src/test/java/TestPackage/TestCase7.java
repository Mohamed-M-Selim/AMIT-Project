package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.P01_Home;
import org.example.pages.P07_TestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P07_TestCases testCasesPage;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        testCasesPage = new P07_TestCases(driver, testData);
    }

    @Test
    public void testCaseSeven(){
        homePage.navigateToHome().clickOnTestCasesButton();
        testCasesPage.verifyTestCasesPage();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
