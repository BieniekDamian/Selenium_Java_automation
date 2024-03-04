package pageObjects;

import helpers.WaitForElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs_PO extends Actions {

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

    public ContactUs_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactUs_PO openContactUsPage() {
        WaitForElementHelper waits = new WaitForElementHelper(driver);
        button_click(contact_us_btn);
        waits.waitForElementVisibilityById("recipient-email");
        return this;
    }

    public ContactUs_PO inputData(String email, String name, String message) {
        input_text(recipent_email_input, email);
        input_text(recipent_name_input, name);
        input_text(message_input, message);
        return this;
    }

    public ContactUs_PO clickSendMessage() {
        button_click(send_message_btn);
        return this;
    }
}
