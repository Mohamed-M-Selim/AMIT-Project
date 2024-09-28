package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.P01_Home;
import org.example.pages.P08_Products;
import org.example.pages.P10_CartPage;
import org.example.pages.P11_ProductDetails;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase13 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    P01_Home homePage;
    P10_CartPage cartPage;
    P08_Products productsPage;
    P11_ProductDetails productDetailsPage;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");

        homePage = new P01_Home(driver, testData);
        cartPage = new P10_CartPage(driver, testData);
        productsPage = new P08_Products(driver, testData);
        productDetailsPage = new P11_ProductDetails(driver, testData);
    }

    @Test
    public void testCase13() {
        homePage.navigateToHome().clickViewProductOnProduct4();
        productDetailsPage.setQuantity("4").clickAddToCart();
    try {
    Thread.sleep(2000); // 2-second delay
    } catch (InterruptedException e) {
    e.printStackTrace();
}
        productDetailsPage.clickViewCart();
        cartPage.validateProductQuantity("4");
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
