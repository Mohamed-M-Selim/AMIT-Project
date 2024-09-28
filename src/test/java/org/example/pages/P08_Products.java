package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P08_Products {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    //constructor
    public P08_Products(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By productsList = By.xpath("//div[@class=\"features_items\"]");
    private By viewProduct1 = By.xpath("//a[@href=\"/product_details/1\"]");
    private By searchProductField = By.xpath("//input[@id=\"search_product\"]");
    private By submitSearchButton = By.xpath("//button[@id=\"submit_search\"]");
    private By searchedProductsText = By.xpath("//h2[@class=\"title text-center\"]");
    private By firstProductImage =
            By.xpath("//div[@class=\"productinfo text-center\"]//img[@src=\"/get_product_picture/1\"]");
    private By firstProductAddToCartOverlay =
            By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"1\"]");
    private By secondProductImage =
            By.xpath("//div[@class=\"productinfo text-center\"]//img[@src=\"/get_product_picture/2\"]");
    private By secondProductAddToCartOverlay =
            By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"2\"]");
    private By continueShoppingButton = By.xpath("//button[@data-dismiss=\"modal\"]");
    private By viewCartButton = By.xpath("//div[@class=\"modal-body\"]//a[@href=\"/view_cart\"]");
    private By brandsNames = By.xpath("//div[@class=\"brands-name\"]");
    private By poloBrand = By.xpath("//a[@href=\"/brand_products/Polo\"]");
    private By addToCart30 = By.xpath("//a[@data-product-id=\"30\"]");
    private By cartButton = By.xpath("//a[@href=\"/view_cart\"]//i");

    //methods
    public P08_Products clickOnPoloBrand(){
        driver.element().click(poloBrand);
        return this;
    }

    public P08_Products clickOnViewProduct1(){
        driver.element().click(viewProduct1);
        return this;
    }

    public P08_Products searchForProduct(String productName){
        driver.element().type(searchProductField,productName);
        driver.element().click(submitSearchButton);
        return this ;
    }

    public P08_Products addFirstProductToCart(){
        driver.element().hover(firstProductImage);
        driver.element().click(firstProductAddToCartOverlay);
        return this ;
    }

    public P08_Products clickContinueShopping(){
        driver.element().click(continueShoppingButton);
        return this;
    }

    public P08_Products addSecondProductToCart(){
        driver.element().hover(secondProductImage);
        driver.element().click(secondProductAddToCartOverlay);
        return this ;
    }

    public P08_Products clickViewCart(){
        driver.element().click(viewCartButton);
        return this;
    }

    public P08_Products addSearchedProductsToCart(){
        driver.element().click(addToCart30);
        return this;
    }

    public P08_Products clickOnCartButton(){
        driver.element().click(cartButton);
        return this;
    }


    //Assertions
    @Step()
    public P08_Products verifyTitle(){
        driver.browser().verifyThat().title()
                .equalsIgnoringCaseSensitivity("Automation Exercise - All Products");
        return this;
    }

    @Step("Verify that Brands are visible on left side bar")
    public P08_Products verifyBrandsAreVisible(){
        driver.element().verifyThat(brandsNames).isVisible();
        return this;
    }

    @Step("validate that searched products is displayed")
    public P08_Products validateSearchedProducts(){
        driver.element().verifyThat(searchedProductsText).exists().perform();
        return this ;
    }

    @Step("Verify user is navigated to test cases page successfully")
    public P08_Products verifyProductsPage(){
        driver.browser().verifyThat().url().equals(testData.getTestData("productsUrl"));
        return this;
    }

    @Step("Verify The products list is visible")
    public P08_Products verifyProductsList() {
        driver.element().verifyThat(productsList).isVisible();
        return this;
    }
}
