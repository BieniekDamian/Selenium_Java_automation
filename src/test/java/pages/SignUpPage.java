package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.UUID;

public class SignInPage extends BasePage{

    @FindBy(xpath = ("//a[@id='signin2']"))
    private static WebElement signIn_button;

    @FindBy(xpath = ("//input[@id='sign-username']"))
    private static WebElement username_input;

    @FindBy(xpath = ("//input[@id='sign-password']"))
    private static WebElement password_input;

    @FindBy(xpath = ("//button[@onclick='register()']"))
    private static WebElement register_button;

    @FindBys(@FindBy(xpath = ("")))
    private static List<WebElement> namee;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return "-" + uuid;
    }

    public void scenario() throws InterruptedException {
        // 
        waitForElement(signIn_button);
        signIn_button.click();

        // Input test user credentials
        username_input.sendKeys("test" + generateString());
        password_input.sendKeys("test");
        register_button.click();
        Thread.sleep(500);
        String alertText = get_alert_text();
        assert alertText.equals("Sign up successful.") : "Alert text does not match the expected text.";
    }

}
