package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public static final String login_username = "test";

    @FindBy(xpath = ("//a[@id='login2']"))
    private static WebElement nav_logIn_btn;

    @FindBy(xpath = ("//button[@onClick='logIn()']"))
    private static WebElement logIn_btn;

    @FindBy(xpath = ("//input[@id='loginusername']"))
    private static WebElement login_input;

    @FindBy(xpath = ("//input[@id='loginpassword']"))
    private static WebElement password_input;

//    @FindBy(xpath = ("//a[@id='nameofuser']"))

    @FindBy(xpath = ("//a[@id='nameofuser'][contains(text(), "+login_username+")]"))
    private static WebElement user_name;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scenario() {
        // Open Log In window
        waitForElement(nav_logIn_btn);
        button_click(nav_logIn_btn);

        // Insert login credentials
        input_text(login_input, login_username);
        input_text(password_input, "test");
        button_click(logIn_btn);

        // Assert name of logged in user
        waitForElement(user_name);
        Assert.assertEquals(user_name.getText(), "Welcome test");
    }

}
