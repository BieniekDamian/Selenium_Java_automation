package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PriceCheck extends BasePage{
    @FindBy(xpath = ("//a[contains(text(),'Phones')]"))
    public static WebElement phone_category;

    @FindBys(@FindBy(xpath = ("//div[@class='card h-100']")))
    private static List<WebElement> devices_list;

    @FindBys(@FindBy(xpath = ("//div[@class='card-block']//h4//a")))
    private static List<WebElement> main_page_devices_name_list;

    @FindBys(@FindBy(xpath = ("//div[@class='card-block']//h5")))
    private static List<WebElement> main_page_devices_price_list;

    @FindBy(xpath = ("//h3[@class='price-container']"))
    private static WebElement details_price;

    @FindBy(xpath = ("//a[contains(text(),'Add to cart')]"))
    public static WebElement add_to_cart_btn;

    @FindBy(xpath = ("//a[@id='cartur']"))
    public static WebElement open_cart_btn;

    @FindBy(xpath = ("//tr[@class='success']//td[3]"))
    private static WebElement cart_item_price;

    @FindBy(xpath = ("//h3[@id='totalp']"))
    private static WebElement cart_total_price;

    @FindBy(xpath = ("//h4//a"))
    public static WebElement device_title;

    @FindBy(xpath = ("//button[contains(text(),'Place Order')]"))
    public static WebElement place_order_btn;

    @FindBy(xpath = ("//label[@id='totalm']"))
    public static WebElement order_price;

    @FindBy(xpath = ("//p[@class='lead text-muted ']"))
    public static WebElement purchase_summary;

    @FindBy(xpath = ("//input[@id='name']"))
    public static WebElement name_input;

    @FindBy(xpath = ("//input[@id='card']"))
    public static WebElement credit_card_input;

    @FindBy(xpath = ("//button[contains(text(),'Purchase')]"))
    public static WebElement purchase_btn;

    @FindBy(xpath = ("//button[contains(text(),'OK')]"))
    public static WebElement close_purchase_btn;


    public PriceCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void phone_price_check(String category_name) throws InterruptedException {
        select_category(phone_category);
        waitForElementVisibility("tbodyid");
        Thread.sleep(1000);

        int array_length = devices_list.size();
        for(int i=0; i<array_length; i++){
            // Get item value from main page
            String element_name = main_page_devices_name_list.get(i).getText();
            String element_price = main_page_devices_price_list.get(i).getText().split("\\$")[1].trim();
            System.out.println("Name: " + element_name + " Price: " + element_price);

            // Click on each item during iteration - starts from first displayed item
            main_page_devices_name_list.get(i).click();

            // Get value from details and compare to price from main page
            String price_from_details = details_price.getText().split(" ")[0].split("\\$")[1].trim();
            Assert.assertEquals(element_price, price_from_details);

            // Open Cart
            add_to_cart_btn.click();
            open_cart_btn.click();

            // Get values from cart and compare to price from main page
            String price_from_cart = cart_item_price.getText();
            String total_proce_from_cart = cart_total_price.getText();
            Assert.assertEquals(element_price, price_from_cart);
            Assert.assertEquals(element_price, total_proce_from_cart);

            // Click on place order button
            place_order_btn.click();

            // Get value from order process
            waitForElementVisibility("totalm");
            String price_from_place_order_window = order_price.getText().split("Total: ")[1];
            Assert.assertEquals(element_price, price_from_place_order_window);

            name_input.sendKeys("test");
            credit_card_input.sendKeys("test");
            purchase_btn.click();


            // Get value from purchase summary
            String price_from_purchase_summary = purchase_summary.getText().split("Amount: ")[1].split(" USD")[0];
            Assert.assertEquals(element_price, price_from_purchase_summary);


            Thread.sleep(1000);
            close_purchase_btn.click();
        }
    }

    public void scenario() throws InterruptedException {
        phone_price_check("Phone");

    }

}
