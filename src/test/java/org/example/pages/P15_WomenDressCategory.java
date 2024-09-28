package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P15_WomenDressCategory {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P15_WomenDressCategory(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By categoryTitle = By.xpath("//h2[@class=\"title text-center\"]");
    private By menCategoryPlusButton = By.xpath("//a[@href=\"#Men\"]//i[@class=\"fa fa-plus\"]");
    private By menTshirtsCategoryButton = By.xpath("//a[@href=\"/category_products/3\"]");



    //methods
    public P15_WomenDressCategory clickOnMenCategoryPlus(){
        driver.element().click(menCategoryPlusButton);
        return this;
    }

    public P15_WomenDressCategory clickOnMenTshirtsCategory(){
        driver.element().click(menTshirtsCategoryButton);
        return this;
    }

    //Assertions
    @Step("Verify Title is 'Automation Exercise - Dress Products'")
    public P15_WomenDressCategory verifyCategoryText(){
        driver.browser().verifyThat().title()
                .equalsIgnoringCaseSensitivity("Automation Exercise - Dress Products");
        return this;
    }
}
