package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P05_AccountDeleted {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    //constructor
    public P05_AccountDeleted(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By accountDeleted = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    //methods
    public P05_AccountDeleted clickContinueButton(){
        driver.element().click(continueButton);
        return this;
    }

    //Assertions
    @Step("Verify that 'ACCOUNT DELETED!' is visible")
    public P05_AccountDeleted verifyAccountDeleted(){
        driver.element().verifyThat(accountDeleted).text()
                .equals(testData.getTestData("accountDeleted"));
        return this;
    }



}
