package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P16_MenTshirtsCategory {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P16_MenTshirtsCategory(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By categoryTitle = By.xpath("//h2[@class=\"title text-center\"]");

    //methods

    //Assertions
    @Step("Verify Title is 'Automation Exercise - Tshirts Products'")
    public P16_MenTshirtsCategory verifyCategoryText(){
        driver.browser().verifyThat().title()
                .equalsIgnoringCaseSensitivity("Automation Exercise - Tshirts Products");
        return this;
    }
}
