package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase21 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @Test
    public void testCase21() {
        new P01_Home(driver, testData).navigateToHome().clickOnProductsButton();
        new P08_Products(driver, testData).verifyTitle().verifyProductsList()
                .clickOnViewProduct1();
        new P09_Product1(driver, testData).enterReviewDetails()
                .clickOnSubmitReview().verifyReviewSubmission();

    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
