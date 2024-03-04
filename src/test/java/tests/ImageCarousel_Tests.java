package tests;
import helpers.RetryAnalyzer;
import org.testng.annotations.Test;
import pageObjects.*;

public class ImageCarousel_Tests extends SetupConfiguration {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void openMainPageAndVerifySliderImages() throws InterruptedException {
        // Arrange
        driver.get(baseUrl);
        ImageCarousel_PO imageCarousel = new ImageCarousel_PO(driver);

        // Act
        imageCarousel
                .selectSlideAndCheckVisibility("0", "Samsung1.jpg")
                .selectSlideAndCheckVisibility("1", "nexus1.jpg")
                .selectSlideAndCheckVisibility("2", "iphone1.jpg");

    }
}
