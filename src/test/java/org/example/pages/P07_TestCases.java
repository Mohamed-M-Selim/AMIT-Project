package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P07_TestCases {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    //constructor
    public P07_TestCases(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By getInTouchText = By.xpath("//div[@class=\"contact-form\"]//h2[@class=\"title text-center\"]");

    //methods


    //Assertions
    @Step("Verify user is navigated to test cases page successfully")
    public P07_TestCases verifyTestCasesPage(){
        driver.browser().verifyThat().url().equals(testData.getTestData("testCasesPageUrl"));
        return this;
    }


}
