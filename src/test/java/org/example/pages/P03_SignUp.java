package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_SignUp {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;


    //constructor
    public P03_SignUp(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By enterAccountInformationText = By.xpath(
            "//h2[@class=\"title text-center\"]//b[text()='Enter Account Information']");
    private By selectTitleOne = By.xpath("//div[@id=\"uniform-id_gender1\"]");
    private By nameField = By.xpath("//input[@id=\"name\"]");
    private By emailField = By.xpath("//input[@data-qa=\"email\"]");
    private By passwordField = By.xpath("//input[@data-qa=\"password\"]");
    private By dayDropDown = By.xpath("//select[@id=\"days\"]");
    private By monthDropDown = By.xpath("//select[@id=\"months\"]");
    private By yearDropDown = By.xpath("//select[@id=\"years\"]");
    private By newsletterCheckbox = By.xpath("//input[@id=\"newsletter\"]");
    private By offersCheckbox = By.xpath("//input[@id=\"optin\"]");
    private By firstNameField = By.xpath("//input[@id=\"first_name\"]");
    private By lastNameField = By.xpath("//input[@id=\"last_name\"]");
    private By companyField = By.xpath("//input[@id=\"company\"]");
    private By adressField = By.xpath("//input[@id=\"address1\"]");
    private By adress2Field = By.xpath("//input[@id=\"address2\"]");
    private By countryDropDown = By.xpath("//select[@id=\"country\"]");
    private By stateField = By.xpath("//input[@id=\"state\"]");
    private By cityField = By.xpath("//input[@id=\"city\"]");
    private By zipCodeField = By.xpath("//input[@id=\"zipcode\"]");
    private By mobileField = By.xpath("//input[@id=\"mobile_number\"]");
    private By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");
    private By emailAlreadyExists = By.xpath("//form[@action=\"/signup\"]//p");

    //methods

    public boolean checkEmailAlreadyExists(){
        if(driver.element().isElementDisplayed(emailAlreadyExists)){
            return true;
        }
        return false;
    }

    public P03_SignUp selectTitleOne(){
        driver.element().click(selectTitleOne);
        return this;
    }
    public P03_SignUp fillAccountInformation(){
        /*driver.element().type(nameField, testData.getTestData("lastName"));*/
        /*driver.element().type(emailField, testData.getTestData("email"));*/
        driver.element().type(passwordField, testData.getTestData("registerData.password"));
        driver.element().select(dayDropDown, testData.getTestData("registerData.birthDateDay"));
        driver.element().select(monthDropDown, testData.getTestData("registerData.birthDateMonth"));
        driver.element().select(yearDropDown, testData.getTestData("registerData.birthDateYear"));
        return this;
    }
    public P03_SignUp fillSignupSetup(){
        /*driver.element().type(nameField, testData.getTestData("lastName"));*/
        /*driver.element().type(emailField, testData.getTestData("email"));*/
        driver.element().type(passwordField, testData.getTestData("loginData.password"));
        driver.element().select(dayDropDown, testData.getTestData("registerData.birthDateDay"));
        driver.element().select(monthDropDown, testData.getTestData("registerData.birthDateMonth"));
        driver.element().select(yearDropDown, testData.getTestData("registerData.birthDateYear"));
        return this;
    }

    public P03_SignUp newsletterCheckbox(){
        driver.element().click(newsletterCheckbox);
        return this;
    }

    public P03_SignUp offersCheckbox(){
        driver.element().click(offersCheckbox);
        return this;
    }

    public P03_SignUp fillAddressInformation(){
        driver.element().type(firstNameField, testData.getTestData("registerData.firstName"));
        driver.element().type(lastNameField, testData.getTestData("registerData.lastName"));
        driver.element().type(companyField, testData.getTestData("registerData.company"));
        driver.element().type(adressField, testData.getTestData("registerData.address1"));
        driver.element().type(adress2Field, testData.getTestData("registerData.address2"));
        driver.element().select(countryDropDown, testData.getTestData("registerData.country"));
        driver.element().type(stateField, testData.getTestData("registerData.state"));
        driver.element().type(cityField, testData.getTestData("registerData.city"));
        driver.element().type(zipCodeField, testData.getTestData("registerData.zipCode"));
        driver.element().type(mobileField, testData.getTestData("registerData.mobile"));
        return this;
    }

    public P03_SignUp clickCreateAccount(){
        driver.element().click(createAccountButton);
        return this;
    }



    //Assertions
    @Step("verify 'Enter Account Information' is Visible")
    public P03_SignUp verifyEnterAccountInformation(){
        driver.element().verifyThat(enterAccountInformationText).isVisible();
        return this;
    }

    @Step("verify error 'Email Address already exist!' is Visible")
    public P03_SignUp verifyEmailAlreadyExists(){
        driver.element().verifyThat(emailAlreadyExists).isVisible();
        return this;
    }

}
