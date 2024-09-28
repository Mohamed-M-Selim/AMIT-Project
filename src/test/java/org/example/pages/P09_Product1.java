package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P09_Product1 {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    //constructor
    public P09_Product1(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By productName = By.xpath("//div[@class=\"product-information\"]//h2");
    private By productCategory = By.xpath("//div[@class=\"product-information\"]//p[1]");
    private By productPrice = By.xpath("//div[@class=\"product-information\"]//span//span");
    private By productAvailability = By.xpath("//div[@class=\"product-information\"]//p[2]");
    private By productCondition = By.xpath("//div[@class=\"product-information\"]//p[3]");
    private By productBrand = By.xpath("//div[@class=\"product-information\"]//p[4]");
    private By reviewName = By.xpath("//input[@id=\"name\"]");
    private By reviewEmail = By.xpath("//input[@id=\"email\"]");
    private By reviewText = By.xpath("//textarea[@id=\"review\"]");
    private By submitReviewButton = By.xpath("//button[@id=\"button-review\"]");
    private By successMessage = By.xpath("//div[@class=\"alert-success alert\"]//span");

    //methods
    public P09_Product1 enterReviewDetails(){
        driver.element().type(reviewName, testData.getTestData("reviewDetails.name"));
        driver.element().type(reviewEmail, testData.getTestData("reviewDetails.email"));
        driver.element().type(reviewText, testData.getTestData("reviewDetails.review"));
        return this;
    }

    public P09_Product1 clickOnSubmitReview(){
        driver.element().click(submitReviewButton);
        return this;
    }

    //Assertions
    @Step("Verify that review was submitted successfully")
    public P09_Product1 verifyReviewSubmission(){
        driver.element().verifyThat(successMessage).isVisible();
        return this;
    }

    @Step("Verify that product details are visible")
    public P09_Product1 verifyProductDetails(){
        driver.element().verifyThat(productName).text().isNotNull();
        driver.element().verifyThat(productCategory).text().isNotNull();
        driver.element().verifyThat(productPrice).text().isNotNull();
        driver.element().verifyThat(productAvailability).text().isNotNull();
        driver.element().verifyThat(productCondition).text().isNotNull();
        driver.element().verifyThat(productBrand).text().isNotNull();
        return this;
    }
}
