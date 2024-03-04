package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {

    WebDriver driver;

    public void button_click(WebElement button) {
        button.click();
    }

    public void input_text(WebElement input_field, String text) {
        input_field.sendKeys(text);
    }

    public void select_category(WebElement category){
        category.click();
    }
}