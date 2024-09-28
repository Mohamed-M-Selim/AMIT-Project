package org.example.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.io.File;

public class P14_PaymentDone {

    private final SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON testData;

    //constructor
    public P14_PaymentDone(SHAFT.GUI.WebDriver driver, SHAFT.TestData.JSON testData){
        this.driver = driver;
        this.testData = testData;
    }

    //locators
    private final By orderConfirmationText =
            By.xpath("//p[@style=\"font-size: 20px; font-family: garamond;\"]");
    private By deleteAccountButton = By.xpath("//a[@href=\"/delete_account\"]");
    private By downloadInvoiceButton = By.xpath("//a[@href=\"/download_invoice/3400\"]");
    private By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    //methods
    public P14_PaymentDone clickContinueButton(){
        driver.element().click(continueButton);
        return this;
    }

    public P14_PaymentDone clickOnDownloadInvoice(){
        driver.element().click(downloadInvoiceButton);
        return this;
    }

    public P14_PaymentDone deleteAccount(){
        driver.element().click(deleteAccountButton);
        return this;
    }

    //Assertions
    @Step("Verify file download")
    public P14_PaymentDone verifyFileDownload() {
        // Check if the file exists in the download directory
        boolean isFileDownloaded = isFileDownloaded
                ("C:/Users/selim/Desktop/software testing/AMIT project/automationExercise_allTests/target/downloadedFiles",
                "filename.extension");

        // Assert the file is downloaded
        driver.verifyThat().equals(isFileDownloaded);
        return this;
    }

    @Step("Verify success message 'Your order has been placed successfully!'")
    public P14_PaymentDone verifyOrderIsPlaced(){
        driver.element().verifyThat(orderConfirmationText).text()
                .isEqualTo("Congratulations! Your order has been confirmed!");
        return this;
    }

    // Utility method to verify if a file is downloaded
    public boolean isFileDownloaded(String downloadDir, String fileName) {
        File dir = new File(downloadDir);
        File[] files = dir.listFiles((dir1, name) -> name.equals(fileName));

        return files != null && files.length > 0;
    }
}
