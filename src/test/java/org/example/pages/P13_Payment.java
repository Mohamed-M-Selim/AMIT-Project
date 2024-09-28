package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P13_Payment {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P13_Payment(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By nameOnCard = By.xpath("//input[@name=\"name_on_card\"]");
    private final By cardNumber = By.xpath("//input[@name=\"card_number\"]");
    private By cvc = By.xpath("//input[@name=\"cvc\"]");
    private By expiryMonth = By.xpath("//input[@name=\"expiry_month\"]");
    private By expiryYear = By.xpath("//input[@name=\"expiry_year\"]");
    private By payAndConfirmButton = By.xpath("//button[@id=\"submit\"]");

    //methods
    public P13_Payment fillPaymentDetails(){
        driver.element().type(nameOnCard, testData.getTestData("paymentDetails.nameOnCard"));
        driver.element().type(cardNumber, testData.getTestData("paymentDetails.cardNumber"));
        driver.element().type(cvc, testData.getTestData("paymentDetails.cvc"));
        driver.element().type(expiryMonth, testData.getTestData("paymentDetails.expiryMonth"));
        driver.element().type(expiryYear, testData.getTestData("paymentDetails.expiryYear"));
        return this;
    }

    public P13_Payment clickPayAndConfirmButton(){
        driver.element().click(payAndConfirmButton);
        return this;
    }

    //Assertions
    @Step("verify Address Information")
    public P13_Payment verifyAddressInformation(){

        return this;
    }
    /*@Step("validate that searched products is displayed")
    public ProductDetailsPage validateSearchedProducts(){
        driver.element().verifyThat(searchedProductsText).exists().perform();
        return this ;
    }*/
}
