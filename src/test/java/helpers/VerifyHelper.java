package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import tests.SetupConfiguration;

public class VerifyHelper extends SetupConfiguration {

    @FindBy(xpath = ("//a[@id='nameofuser']"))
    private static WebElement logged_user_name;

    public VerifyHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public void verifyTextInAlert(String message) {
        String alertText = getAlertText();
        assert alertText.equals(message) : "Alert text does not match the expected text.";
    }

    public void verifyLoggedInUser(String username){
        WaitForElementHelper waits = new WaitForElementHelper(driver);
        waits.waitForElementVisibilityById("nameofuser");
        Assert.assertEquals(logged_user_name.getText(), "Welcome "+username);
    }

}
