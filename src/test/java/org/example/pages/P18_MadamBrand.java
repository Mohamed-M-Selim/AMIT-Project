package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P18_MadamBrand {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P18_MadamBrand(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By categoryTitle = By.xpath("//h2[@class=\"title text-center\"]");
    private By madamBrand = By.xpath("href=\"/brand_products/Madame\"");

    //methods
    public P18_MadamBrand clickOnMadamBrand(){
        driver.element().click(madamBrand);
        return this;
    }

    //Assertions
    @Step("Verify that Title is 'Automation Exercise - Madame Products'")
    public P18_MadamBrand verifyTitle(){
        driver.browser().verifyThat().title()
                .equalsIgnoringCaseSensitivity("Automation Exercise - Madame Products");
        return this;
    }
}
