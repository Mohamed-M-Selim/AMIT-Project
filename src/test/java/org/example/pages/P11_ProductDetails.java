package org.example.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P11_ProductDetails {

    private final SHAFT.GUI.WebDriver driver;

    //constructor
    public P11_ProductDetails(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
    }

    //locators
    private final By quantityBox = By.xpath("//input[@name=\"quantity\"]");
    private final By addToCart = By.xpath("//button[@class=\"btn btn-default cart\"]");
    private final By viewCartWindow = By.xpath("//a[@href=\"/view_cart\"]//u");

    //methods
    public P11_ProductDetails setQuantity(String quantity){
        driver.element().setValueUsingJavaScript(quantityBox, quantity);
        return this;
    }

    public void clickAddToCart(){
        driver.element().click(addToCart);
    }

    public void clickViewCart(){
        driver.element().click(viewCartWindow);
    }

    //Assertions
    /*@Step("validate that searched products is displayed")
    public ProductDetailsPage validateSearchedProducts(){
        driver.element().verifyThat(searchedProductsText).exists().perform();
        return this ;
    }*/
}
