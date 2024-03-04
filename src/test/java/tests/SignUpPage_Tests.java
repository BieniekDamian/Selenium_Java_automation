package tests;
import helpers.RetryAnalyzer;
import helpers.VerifyHelper;
import helpers.Helpers;
import org.testng.annotations.Test;
import pageObjects.*;

public class SignUpPage_Tests extends SetupConfiguration {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void openSignUpPopUpAndRegisterNewUser() throws InterruptedException {
        // Arrange
        driver.get(baseUrl);
        SignUpPage_PO signUp = new SignUpPage_PO(driver);
        VerifyHelper verifyHelper = new VerifyHelper(driver);
        Helpers helpers = new Helpers();
        String login = "test",
               identifier = helpers.generateString(),
               password = "Tester";

        // Act
        signUp
                .openSignUpPopUp()
                .inputCredentials(login, identifier, password);

        // Assert
        verifyHelper.verifyTextInAlert("Sign up successful.");
    }
}
