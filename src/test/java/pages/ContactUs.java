package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends  BasePage{

    @FindBy(xpath = ("//a[contains(text(),'Contact')]"))
    private static WebElement contact_us_btn;

    @FindBy(xpath = ("//input[@id='recipient-email']"))
    private static WebElement recipent_email_input;

    @FindBy(xpath = ("//input[@id='recipient-name']"))
    private static WebElement recipent_name_input;

    @FindBy(xpath = ("//textarea[@id='message-text']"))
    private static WebElement message_input;

    @FindBy(xpath = ("//button[contains(text(),'Send message')]"))
    private static WebElement send_message_btn;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scenario() {
        // Open Contact Us window
        button_click(contact_us_btn);
        waitForElementVisibility("recipient-email");

        // Input testing data
        input_text(recipent_email_input, "test@mail.com");
        input_text(recipent_name_input, "Tester");
        input_text(message_input, "Test Message");

        // Click on send message button
        button_click(send_message_btn);

        // Assert alert message
        String alertText = get_alert_text();
        assert alertText.equals("Thanks for the message!!") : "Alert text does not match the expected text.";
    }
}
