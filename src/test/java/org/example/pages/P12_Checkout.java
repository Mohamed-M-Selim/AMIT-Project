package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P12_Checkout {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P12_Checkout(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By name = By.xpath
            ("//ul[@id=\"address_delivery\"]//li[@class=\"address_firstname address_lastname\"]");
    private By company = By.xpath
            ("//ul[@id=\"address_delivery\"]//li[@class=\"address_address1 address_address2\"][1]");
    private By address1 = By.xpath
            ("//ul[@id=\"address_delivery\"]//li[@class=\"address_address1 address_address2\"][2]");
    private By address2 = By.xpath
            ("//ul[@id=\"address_delivery\"]//li[@class=\"address_address1 address_address2\"][3]");
    private By country = By.xpath
            ("//ul[@id=\"address_delivery\"]//li[@class=\"address_country_name\"]");
    private By mobile = By.xpath
            ("//ul[@id=\"address_delivery\"]//li[@class=\"address_phone\"]");
    private By commentTextBox = By.xpath("//textarea[@name=\"message\"]");
    private By placeOrderButton = By.xpath("//a[@href=\"/payment\"]");
    private final By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");

    //methods
    public P12_Checkout fillCommentBox(){
        driver.element().type(commentTextBox, testData.getTestData("comment"));
        return this;
    }

    public P12_Checkout clickPlaceOrderButton(){
        driver.element().click(placeOrderButton);
        return this;
    }

    public P12_Checkout clickDeleteAccount(){
        driver.element().click(deleteAccountButton);
        return this;
    }

    //Assertions
    @Step("verify Address Information")
    public P12_Checkout verifyAddressInformation(){
        driver.element().verifyThat(name).text().equalsIgnoringCaseSensitivity
                (testData.getTestData("registerData.title")
                + " " + testData.getTestData("registerData.firstName")
                + " " + testData.getTestData("registerData.lastName"));
        driver.element().verifyThat(company).text().equalsIgnoringCaseSensitivity
                (testData.getTestData("registerData.company"));
        driver.element().verifyThat(address1).text().equalsIgnoringCaseSensitivity
                (testData.getTestData("registerData.address1"));
        driver.element().verifyThat(address2).text().equalsIgnoringCaseSensitivity
                (testData.getTestData("registerData.address2"));
        driver.element().verifyThat(country).text().equalsIgnoringCaseSensitivity
                (testData.getTestData("registerData.country"));
        driver.element().verifyThat(mobile).text().equalsIgnoringCaseSensitivity
                (testData.getTestData("registerData.mobile"));
        return this;
    }
    /*@Step("validate that searched products is displayed")
    public ProductDetailsPage validateSearchedProducts(){
        driver.element().verifyThat(searchedProductsText).exists().perform();
        return this ;
    }*/
}
