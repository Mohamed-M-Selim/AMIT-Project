package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P10_CartPage {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P10_CartPage(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By subscriptionText = By.xpath("//div[@class=\"single-widget\"]//h2");
    private final By subscribeEmail = By.xpath("//input[@id=\"susbscribe_email\"]");
    private final By successSubscribe = By.xpath("//div[@id=\"success-subscribe\"]");
    private final By firstProductName =
            By.xpath("//a[@href=\"/product_details/1\"]");
    private final By firstProductPrice =
            By.xpath("//tr[@id=\"product-1\"]//td[@class=\"cart_price\"]");
    private final By firstProductQuantity =
            By.xpath("//tr[@id=\"product-1\"]//td[@class=\"cart_quantity\"]//button");
    private final By firstProductTotalPrice =
            By.xpath("//tr[@id=\"product-1\"]//p[@class=\"cart_total_price\"]");
    private final By secondProductName =
            By.xpath("//a[@href=\"/product_details/2\"]");
    private final By secondProductPrice =
            By.xpath("//tr[@id=\"product-2\"]//td[@class=\"cart_price\"]");
    private final By secondProductQuantity =
            By.xpath("//tr[@id=\"product-2\"]//td[@class=\"cart_quantity\"]//button");
    private final By secondProductTotalPrice =
            By.xpath("//tr[@id=\"product-2\"]//p[@class=\"cart_total_price\"]");
    private final By fourthProductQuantity =
            By.xpath("//tr[@id=\"product-4\"]//td[@class=\"cart_quantity\"]//button");
    private final By proccedToCheckoutButton =
            By.xpath("//a[@class=\"btn btn-default check_out\"]");
    private By registerButton = By.xpath("//a[@href=\"/login\"]//u");
    private By firstProductRemoveButton = By.xpath("//a[@data-product-id=\"1\"]");
    private By loginButton = By.xpath("//a[@href=\"/login\"]//i");
    private By searchedProduct = By.xpath("//a[@href=\"/product_details/30\"]");
    private By recommendedItem2 = By.xpath("//a[@href=\"/product_details/2\"]");


    //methods
    public P10_CartPage clickOnLoginButton(){
        driver.element().click(loginButton);
        return this;
    }

    public P10_CartPage removeFirstProduct(){
        driver.element().click(firstProductRemoveButton);
        return this;
    }

    public P10_CartPage enterEmailInSubscriptionField(){
        driver.element().type(subscribeEmail, testData.getTestData("subscribeEmail"));
        return this;
    }

    public P10_CartPage clickOnProceedToCheckout(){
        driver.element().click(proccedToCheckoutButton);
        return this;
    }

    public P10_CartPage clickOnRegisterButton(){
        driver.element().click(registerButton);
        return this;
    }

    //Assertions
    @Step("Verify that Recommended Item 2 is displayed")
    public P10_CartPage verifyRecommendedItem2(){
        driver.element().verifyThat(recommendedItem2).isVisible();
        return this;
    }

    @Step("Verify searched Product is displayed in cart page")
    public P10_CartPage validateSearchedProduct(){
        driver.element().verifyThat(searchedProduct).isVisible();
        return this;
    }
    @Step("Verify that the first product is removed from the cart")
    public P10_CartPage verifyFirstProductIsRemoved(){
        driver.element().verifyThat(firstProductName).doesNotExist();
        return this;
    }

    @Step("Verify both products are added to Cart")
    public P10_CartPage validateProductsAreAddedToCart(){
        driver.element().verifyThat(firstProductName).isVisible();
        driver.element().verifyThat(secondProductName).isVisible();
        return this ;
    }

    @Step("Verify their prices")
    public P10_CartPage validatePrices(){
        driver.element().verifyThat(firstProductPrice).isVisible();
        driver.element().verifyThat(secondProductPrice).isVisible();
        return this ;
    }

    @Step("Verify their quantity")
    public P10_CartPage validateQuantities(){
        driver.element().verifyThat(firstProductQuantity).isVisible();
        driver.element().verifyThat(secondProductQuantity).isVisible();
        return this ;
    }

    @Step("Verify their total price")
    public P10_CartPage validateTotalPrices(){
        driver.element().verifyThat(firstProductTotalPrice).isVisible();
        driver.element().verifyThat(secondProductTotalPrice).isVisible();
        return this ;
    }

    @Step("7. Verify success message 'You have been successfully subscribed!' is visible")
    public P10_CartPage validateSubscriptionSuccess(){
        driver.element().verifyThat(successSubscribe).isVisible();
        return this;
    }

    @Step("Verify text 'SUBSCRIPTION'")
    public P10_CartPage verifySubscriptionText(){
        driver.element().verifyThat(subscriptionText).text().isEqualTo("SUBSCRIPTION");
        return this;
    }

    @Step("Verify that product is displayed in cart page with exact quantity")
    public P10_CartPage validateProductQuantity(String quantity){
        driver.element().verifyThat(fourthProductQuantity).text().equals(quantity);
        return this ;
    }

    @Step("Verify that cart page is displayed")
    public P10_CartPage verifyCartPage(){
        driver.browser().verifyThat().url()
                .equals(testData.getTestData("cartUrl"));
        return this;
    }
}
