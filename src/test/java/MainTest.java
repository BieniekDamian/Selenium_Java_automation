import helpers.RetryAnalyzer;
import org.testng.annotations.Test;
import pages.*;


public class MainTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void sign_up_method() throws InterruptedException {
        driver.get(baseUrl);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.scenario();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void login_in_method() throws InterruptedException {
        driver.get(baseUrl);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.scenario();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void image_carousel() throws InterruptedException {
        driver.get(baseUrl);
        ImageCarousel imageCarousel = new ImageCarousel(driver);

        imageCarousel.scenario();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void price_check() throws InterruptedException {
        driver.get(baseUrl);
        PriceCheck priceCheck = new PriceCheck(driver);

        priceCheck.scenario();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void contact_us() {
        driver.get(baseUrl);
        ContactUs contactUs = new ContactUs(driver);

        contactUs.scenario();
    }
}
