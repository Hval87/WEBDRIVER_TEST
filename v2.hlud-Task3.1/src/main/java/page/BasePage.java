package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverManager;
import util.Waiting;

public abstract class BasePage {
    protected WebDriver driver;
    private By uniqueLocator;
    private String name;
    private Waiting waiting = new Waiting();

    public BasePage(By unLocator, String name) {
        this.uniqueLocator = unLocator;
        this.name = name;
        this.driver = DriverManager.createDriver();
    }

    protected boolean isPageOpen() {
        boolean result;
        if(!driver.findElements(uniqueLocator).isEmpty()){
           result=true;
        }
        else{
            result=false;
        }
        return result;
    }

    public boolean textContainedInPage(String text, By locatorForTextField) {
        WebElement textField = driver.findElement(locatorForTextField);
        boolean result = textField.getText().contains(text);
        return result;
    }
}