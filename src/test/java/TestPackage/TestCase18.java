package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.example.pages.P01_Home;
import org.example.pages.P15_WomenDressCategory;
import org.example.pages.P16_MenTshirtsCategory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase18 {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @BeforeMethod
    @Description("this is a setup method for our test")
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @Test
    public void testCase18() {
        new P01_Home(driver, testData).navigateToHome()
                .verifyCategoriesAreVisible().clickWomanCategoryPlusButton()
                .clickDressCategoryButton();
        new P15_WomenDressCategory(driver, testData).verifyCategoryText()
                .clickOnMenCategoryPlus().clickOnMenTshirtsCategory();
        new P16_MenTshirtsCategory(driver, testData).verifyCategoryText();
    }

    @AfterMethod
    @Description("Close browser after test")
    public void afterMethod(){
        driver.quit();
    }

}
