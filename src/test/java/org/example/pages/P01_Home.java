package org.example.pages;

import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_Home {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;


    //constructor
    public  P01_Home(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By subscriptionText = By.xpath("//div[@class=\"single-widget\"]//h2");
    private final By subscribeEmail = By.xpath("//input[@id=\"susbscribe_email\"]");
    private final By arrowButton = By.xpath("//i[@class=\"fa fa-arrow-circle-o-right\"]");
    private final By successSubscribe = By.xpath("//div[@id=\"success-subscribe\"]");
    private final By viewProductButtonProduct4 =
            By.xpath("//a[@href=\"/product_details/4\"]//i[@class=\"fa fa-plus-square\"]");
    private final By loginButton = By.xpath("//a[@href=\"/login\"]");
    private final By loggedInAs = By.xpath("//b");
    private final By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private final By logoutButton = By.xpath("//a[@href=\"/logout\"]");
    private final By contactUsButton = By.xpath("//a[@href=\"/contact_us\"]");
    private final By testCasesButton = By.xpath("//a[@href=\"/test_cases\"]//i");
    private final By productsButton = By.xpath("//a[@href=\"/products\"]");
    private final By cartButton = By.xpath("//a[@href=\"/view_cart\"]//i");
    private final By continueShoppingButton = By.xpath("//button[@data-dismiss=\"modal\"]");

    private final By product1AddToCartButton = By.xpath
            ("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"1\"]");
    private final By product2AddToCartButton = By.xpath
            ("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"2\"]");
    private final By product3AddToCartButton = By.xpath
            ("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"3\"]");
    private final By product4AddToCartButton = By.xpath
            ("//div[@class=\"productinfo text-center\"]//a[@data-product-id=\"4\"]");
    private final By categories = By.xpath("//div[@class=\"panel-group category-products\"]");
    private final By womanCategoryPlusButton = By.xpath("//a[@href=\"#Women\"]//i[@class=\"fa fa-plus\"]");
    private final By DressCategoryButton = By.xpath("//a[@href=\"/category_products/1\"]");
    private final By recommendedItems = By.xpath("//div[@class=\"recommended_items\"]");
    private final By addToCartRecommendedItem2 = By.xpath("//div[@class=\"carousel-inner\"]//a[@data-product-id=\"2\"]");
    private final By viewCartButton = By.xpath("//a[@href=\"/view_cart\"]//u");
    private final By rollUpButton = By.xpath("//a[@id=\"scrollUp\"]");
    private final By fullFledgedPracticeWebsiteText = By.xpath("//div[@class=\"col-sm-6\"]//h2");

    //methods
    public P01_Home clickRollUpButton(){
        driver.element().click(rollUpButton);
        return this;
    }

    public void clickViewCartButton(){
        driver.element().click(viewCartButton);
    }

    public P01_Home clickAddToCartRecommendedItem2(){
        driver.element().click(addToCartRecommendedItem2);
        try {
            Thread.sleep(1000); // 1-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void clickDressCategoryButton(){
        driver.element().click(DressCategoryButton);
    }

    public P01_Home clickWomanCategoryPlusButton(){
        driver.element().click(womanCategoryPlusButton);
        return this;
    }

    public void clickContinueShopping(){
        driver.element().click(continueShoppingButton);
    }

    public P01_Home addToCart(){
        driver.element().click(product1AddToCartButton);
        clickContinueShopping();
        try {
            Thread.sleep(2000); // 2-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.element().click(product2AddToCartButton);
        clickContinueShopping();
        try {
            Thread.sleep(2000); // 2-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.element().click(product3AddToCartButton);
        clickContinueShopping();
        try {
            Thread.sleep(2000); // 2-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.element().click(product4AddToCartButton);
        clickContinueShopping();
        return this;
    }

    public P01_Home clickOnCartButton(){
        driver.element().click(cartButton);
        return this;
    }

    public void clickOnTestCasesButton(){
        driver.element().click(testCasesButton);
    }

    public void clickOnContactUs(){
        driver.element().click(contactUsButton);
    }

    public P01_Home navigateToHome(){
        driver.browser().navigateToURL(testData.getTestData("homePageUrl"));
        driver.browser().verifyThat().url().equals(testData.getTestData("homePageUrl"));
        return this ;
    }

    public P01_Home clickOnLoginButton(){
        driver.element().click(loginButton);
        return this;
    }

    public void clickOnLogoutButton(){
        driver.element().click(logoutButton);
    }

    public void clickViewProductOnProduct4(){
        driver.element().click(viewProductButtonProduct4);
    }

    public void clickOnProductsButton(){
        driver.element().click(productsButton);
    }

    public P01_Home enterEmailInSubscriptionField(){
        driver.element().type(subscribeEmail, testData.getTestData("subscribeEmail"));
        return this ;
    }

    public P01_Home clickArrowButton(String productName){
        driver.element().click(arrowButton);
        return this ;
    }

    public void clickDeleteAccount(){
        driver.element().click(deleteAccountButton);
    }

    //Assertions
    @Step("Verify 'Full-Fledged practice website for Automation Engineers' text is visible on screen")
    public void verifyRollUpWorks(){
        driver.verifyThat().element(fullFledgedPracticeWebsiteText).isVisible();
    }

    @Step("Verify that recommended items are visible")
    public P01_Home verifyRecommendedItemsAreVisible(){
        driver.element().verifyThat(recommendedItems).isVisible();
        return this ;
    }

    @Step("Verify that categories are visible on left side bar")
    public P01_Home verifyCategoriesAreVisible(){
        driver.element().verifyThat(categories).isVisible();
        return this ;
    }

    @Step("Verify text 'SUBSCRIPTION'")
    public P01_Home verifyHomePageIsVisible(){
        driver.browser().verifyThat().title().equals("Automation Exercise");
        return this ;
    }

    @Step("Verify text 'SUBSCRIPTION'")
    public P01_Home validateTextSubscription(){
        driver.element().verifyThat(subscriptionText).isVisible();
        return this ;
    }

    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    public P01_Home validateSubscriptionSuccess(){
        driver.element().verifyThat(successSubscribe).isVisible();
        return this ;
    }

    @Step("Verify that 'Logged in as username' is visible")
    public P01_Home verifyLoggedInAs(){
        driver.element().verifyThat(loggedInAs).text()
                .equals(testData.getTestData("registerData.lastName"));
        return this;
    }

}