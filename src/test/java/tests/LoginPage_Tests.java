package tests;
import helpers.RetryAnalyzer;
import helpers.VerifyHelper;
import org.testng.annotations.Test;
import pageObjects.*;

public class LoginPage_Tests extends SetupConfiguration {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void goToLogInPageAndCheckAuthorization() {
        // Arrange
        driver.get(baseUrl);
        LoginPage_PO loginPage = new LoginPage_PO(driver);
        VerifyHelper verifyHelper = new VerifyHelper(driver);
        String login = "test",
               password = "test";

        // Act
        loginPage
                .openLogInPage()
                .insertLoginCredentials(login, password);

        // Assert
        verifyHelper.verifyLoggedInUser(login);
    }
}
