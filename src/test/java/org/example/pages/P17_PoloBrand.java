package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P17_PoloBrand {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P17_PoloBrand(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By categoryTitle = By.xpath("//h2[@class=\"title text-center\"]");
    private By madamBrand = By.xpath("//a[@href=\"/brand_products/Madame\"]");

    //methods
    public P17_PoloBrand clickOnMadamBrand(){
        driver.element().click(madamBrand);
        return this;
    }

    //Assertions
    @Step("Verify that Title is 'Automation Exercise - Polo Products'")
    public P17_PoloBrand verifyTitle(){
        driver.browser().verifyThat().title()
                .equalsIgnoringCaseSensitivity("Automation Exercise - Polo Products");
        return this;
    }
}
