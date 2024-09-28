package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P06_ContactUs {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    //constructor
    public P06_ContactUs(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By getInTouchText = By.xpath("//div[@class=\"contact-form\"]//h2[@class=\"title text-center\"]");
    private By nameBox = By.xpath("//input[@data-qa=\"name\"]");
    private By emailBox = By.xpath("//input[@data-qa=\"email\"]");
    private By subjectBox = By.xpath("//input[@data-qa=\"subject\"]");
    private By messageBox = By.xpath("//textarea[@data-qa=\"message\"]");
    private By uploadFile = By.xpath("//input[@name=\"upload_file\"]");
    private By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");
    private By successMessage = By.xpath("//div[@class=\"status alert alert-success\"]");
    private By homeButton = By.xpath("//i[@class=\"fa fa-home\"]");

    private String filePath = "C:/Users/selim/Desktop/software testing/AMIT project/01-Project Preparation.pdf";

    //methods
    public P06_ContactUs fillContactForm(){
        driver.element().type(nameBox, testData.getTestData("contactFormData.name"));
        driver.element().type(emailBox, testData.getTestData("contactFormData.email"));
        driver.element().type(subjectBox, testData.getTestData("contactFormData.subject"));
        driver.element().type(messageBox, testData.getTestData("contactFormData.message"));
        return this;
    }

    public P06_ContactUs uploadFile(){
        driver.element().type(uploadFile, filePath);
        return this;
    }

    public P06_ContactUs clickOnSubmit(){
        driver.element().click(submitButton);
        return this;
    }

    public P06_ContactUs handleAlertClickOk(){
        driver.alert().acceptAlert();
        return this;
    }

    public P06_ContactUs clickOnHomeButton(){
        driver.element().click(homeButton);
        driver.browser().verifyThat().url().equals(testData.getTestData("homePageUrl"));
        return this;
    }

    //Assertions
    @Step("Verify 'GET IN TOUCH' is visible")
    public P06_ContactUs verifyGetInTouch(){
        driver.element().verifyThat(getInTouchText).isVisible();
        return this;
    }

    @Step("Verify 'Success! Your details have been submitted successfully.' is visible")
    public P06_ContactUs verifySuccessMessage(){
        driver.element().verifyThat(successMessage).isVisible();
        return this;
    }


}
