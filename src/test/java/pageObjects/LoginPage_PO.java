package pageObjects;

import helpers.WaitForElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PO extends Actions {

    public static final String login_username = "test";

    @FindBy(xpath = ("//a[@id='login2']"))
    private static WebElement nav_logIn_btn;

    @FindBy(xpath = ("//button[@onClick='logIn()']"))
    private static WebElement logIn_btn;

    @FindBy(xpath = ("//input[@id='loginusername']"))
    private static WebElement login_input;

    @FindBy(xpath = ("//input[@id='loginpassword']"))
    private static WebElement password_input;

    @FindBy(xpath = ("//a[@id='nameofuser'][contains(text(), "+login_username+")]"))
    private static WebElement user_name;

    public LoginPage_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage_PO openLogInPage() {
        WaitForElementHelper waits = new WaitForElementHelper(driver);
        waits.waitForElementClickable(nav_logIn_btn);
        button_click(nav_logIn_btn);
        return this;
    }

    public LoginPage_PO insertLoginCredentials(String login, String password) {
        input_text(login_input, login);
        input_text(password_input, password);
        button_click(logIn_btn);
        return this;
    }

}
