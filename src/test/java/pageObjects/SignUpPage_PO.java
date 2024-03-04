package pageObjects;

import helpers.WaitForElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUpPage_PO extends Actions {

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

    public SignUpPage_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpPage_PO openSignUpPopUp(){
        WaitForElementHelper waits = new WaitForElementHelper(driver);
        waits.waitForElementClickable(signIn_button);
        signIn_button.click();
        return this;
    }

    public SignUpPage_PO inputCredentials(String login, String identifier, String password) throws InterruptedException {
        username_input.sendKeys("test" + identifier);
        password_input.sendKeys("test");
        register_button.click();
        Thread.sleep(500);
        return this;
    }
}
