package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import util.DriverManager;

public class JSUtils {


    public static void JSclick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.createDriver();
        js.executeScript("arguments[0].click();", element);
    }


}
