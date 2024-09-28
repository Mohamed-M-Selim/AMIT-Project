package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.P01_Home;
import org.example.pages.P08_Products;
import org.example.pages.P09_Product1;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P08_Products productsPage;
    P09_Product1 product1Page;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        productsPage = new P08_Products(driver, testData);
        product1Page = new P09_Product1(driver, testData);
    }

    @Test
    public void testCase8(){
        homePage.navigateToHome().clickOnProductsButton();
        productsPage.verifyProductsPage().verifyProductsList().clickOnViewProduct1();
        product1Page.verifyProductDetails();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
