package element;

import actions.JSUtils;
import org.openqa.selenium.*;
import org.testng.log4testng.Logger;
import util.DriverManager;
import util.Waiting;

public abstract class BaseElement {
    private WebDriver driver;
    private Waiting waiting;
    private By locator;
    private String name;
    final static Logger logger = Logger.getLogger(BaseElement.class);

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;

        driver = DriverManager.createDriver();
        waiting = new Waiting();
    }

    public WebElement getElement() {
        logger.trace(String.format(" element %s is received", getName()));
        WebElement element = waiting.waitVisibility(driver.findElement(locator));
        return element;
    }

    public String getName() {
        return name;
    }

    public void clickToElement() {
        logger.trace(String.format("element %s is clicked", getName()));
        WebElement element = driver.findElement(locator);
        waiting.waitClickability(element);
        element.click();
    }

    public void clickInterceptedElement() {
        logger.trace(String.format("intercepted element %s is clicked", getName()));
        JSUtils.JSclick(getElement());
    }

}
