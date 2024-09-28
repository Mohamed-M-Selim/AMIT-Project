package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.P01_Home;
import org.example.pages.P08_Products;
import org.example.pages.P10_CartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase12 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P10_CartPage cartPage;
    P08_Products productsPage;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        cartPage = new P10_CartPage(driver, testData);
        productsPage = new P08_Products(driver, testData);
    }

    @Test
    public void testCase12() {
        homePage.navigateToHome().clickOnProductsButton();
        productsPage.addFirstProductToCart()
                .clickContinueShopping()
                .addSecondProductToCart()
                .clickViewCart();
        cartPage.validateProductsAreAddedToCart()
                .validatePrices()
                .validateQuantities()
                .validateTotalPrices();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
