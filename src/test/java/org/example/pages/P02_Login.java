package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_Login {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;


    //constructor
    public P02_Login(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private By signUpFormText = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By logInFormText = By.xpath("//div[@class=\"login-form\"]//h2");
    private By signUpNameField = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By signUpEmailField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    private By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By loginIncorrect = By.xpath("//form[@action=\"/login\"]//p");
    private By incorrectInfoMsg = By.xpath("//form[@action=\"/login\"]/p");

    //methods
    public P02_Login fillNameFieldSignup(){
        driver.element().type(signUpNameField, testData.getTestData("registerData.lastName"));
        return this;
    }

    public P02_Login fillEmailFieldSignup(){
        driver.element().type(signUpEmailField, testData.getTestData("registerData.email"));
        return this;
    }

    public P02_Login clickSignUpButton(){
        driver.element().click(signUpButton);
        return this;
    }

    public P02_Login signInIfSignUpFailed(){
        driver.element().type(loginEmail, testData.getTestData("registerData.email"));
        driver.element().type(loginPassword, testData.getTestData("registerData.password"));
        driver.element().click(loginButton);
        return this;
    }


    public P02_Login fillSetup(){
        driver.element().type(signUpNameField, testData.getTestData("registerData.lastName"));
        driver.element().type(signUpEmailField, testData.getTestData("loginData.email"));
        return this;
    }

    public P02_Login fillLoginInfo(){
        driver.element().type(loginEmail, testData.getTestData("loginData.email"));
        driver.element().type(loginPassword, testData.getTestData("loginData.password"));
        return this;
    }

    public P02_Login fillFalse(){
        driver.element().type(loginEmail, testData.getTestData("loginData.wrongEmail"));
        driver.element().type(loginPassword, testData.getTestData("loginData.wrongPassword"));
        return this;
    }

    public P02_Login clickLoginButton(){
        driver.element().click(loginButton);
        return this;
    }

    //Assertions
    @Step("Verify 'New User Signup!' is visible")
    public P02_Login verifyNewUserSignUp(){
        driver.element().verifyThat(signUpFormText).text()
                .equals(testData.getTestData("signUpForm"));
        return this;
    }

    @Step("Verify 'New User Signup!' is visible")
    public P02_Login verifyLogInToAccount(){
        driver.element().verifyThat(logInFormText).text()
                .equals(testData.getTestData("loginForm"));
        return this;
    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    public P02_Login verifyWrongInputMsg(){
        driver.element().verifyThat(incorrectInfoMsg).text().equals("Your email or password is incorrect!");
        return this;
    }


}
