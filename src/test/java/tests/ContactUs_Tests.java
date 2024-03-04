package tests;
import helpers.RetryAnalyzer;
import helpers.VerifyHelper;
import org.testng.annotations.Test;
import pageObjects.*;

public class ContactUs_Tests extends SetupConfiguration {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void goToContactUsAndSendEmailMessage() {
        // Arrange
        driver.get(baseUrl);
        ContactUs_PO contactUs = new ContactUs_PO(driver);
        VerifyHelper verifyHelper = new VerifyHelper(driver);
        String email = "test@mail.com",
               name = "Tester",
               formMessage = "Test Message",
               alertMessage = "Thanks for the message!!";

        // Act
        contactUs
                .openContactUsPage()
                .inputData(email, name, formMessage)
                .clickSendMessage();

        // Assert
        verifyHelper.verifyTextInAlert(alertMessage);
    }
}
