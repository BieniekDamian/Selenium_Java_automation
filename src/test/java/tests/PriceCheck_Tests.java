package tests;
import helpers.RetryAnalyzer;
import org.testng.annotations.Test;
import pageObjects.*;

public class PriceCheck_Tests extends SetupConfiguration {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkPricesDuringOrderingProcess() throws InterruptedException {
        // Arrange
        driver.get(baseUrl);
        PriceCheck_PO priceCheck = new PriceCheck_PO(driver);

        // Act
        priceCheck
                .categoryPriceCheck("Phone");

    }
}
