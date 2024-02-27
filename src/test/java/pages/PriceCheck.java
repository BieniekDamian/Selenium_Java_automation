package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PhonesPriceCheck extends BasePage{

    @FindBy(xpath = ("//a[contains(text(),'Phones')]"))
    private static WebElement phone_category

    @FindBys(@FindBy(xpath = ("")))
    private static List<WebElement> namee;

    public PhonesPriceCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scenario() throws InterruptedException {
        select_category(phone_category);

    }

}
