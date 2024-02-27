package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ImageCarousel extends BasePage{
    public static final String image = "";

    @FindBy(xpath = ("//div[@id='carouselExampleIndicators']"))
    private static WebElement carousel_container;

    @FindBy(xpath = ("//img[@class='d-block img-fluid'][@src="+image+"]"))
    private static WebElement image_slide;

    public ImageCarousel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verify_slide(String slide_number, String source) throws InterruptedException {
        String image_locator = String.format("//img[@class='d-block img-fluid'][@src='%s']", source);
        String parent_image_locator = String.format("//img[@class='d-block img-fluid'][@src='%s']//..", source);
        String slide_number_locator = String.format("//li[@data-slide-to='%s']", slide_number);

        WebElement image_element = driver.findElement(By.xpath(image_locator));
        WebElement slide_number_element = driver.findElement(By.xpath(slide_number_locator));

        slide_number_element.click();
        waitForElement(image_element);
        Thread.sleep(600);

        WebElement parent_image_element = driver.findElement(By.xpath(parent_image_locator));
        String parent_class = parent_image_element.getAttribute("class");
        Assert.assertTrue(parent_class.contains("active"));

        Assert.assertTrue(image_element.isDisplayed());
    }

    public void scenario() throws InterruptedException {
        waitForElement(carousel_container);

        verify_slide("0", "Samsung1.jpg");
        verify_slide("1", "nexus1.jpg");
        verify_slide("2", "iphone1.jpg");
    }






}
