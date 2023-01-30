package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverManager;

public class Input extends BaseElement {
    private WebDriver driver = DriverManager.createDriver();
    private By locator;
    private String name;

    public Input(By locator, String name) {
        super(locator, name);
        this.locator = locator;
        this.name = name;
    }

    public void sendText(String text) {
        clickToElement();
        getElement().clear();
        getElement().sendKeys(text);
    }
}
