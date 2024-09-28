package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P04_AccountCreated {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;


    //constructor
    public P04_AccountCreated(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By accountCreated = By.xpath("//h2[@data-qa=\"account-created\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    //methods
    public P04_AccountCreated clickContinueButton(){
        driver.element().click(continueButton);
        return this;
    }

    //Assertions
    @Step("Verify that 'ACCOUNT CREATED!' is visible")
    public P04_AccountCreated verifyAccountCreated(){
        driver.element().verifyThat(accountCreated).text()
                .equals(testData.getTestData("accountCreated"));
        return this;
    }

}