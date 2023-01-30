package util;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class BrowserHandleUtil {
    private WebDriver driver = DriverManager.createDriver();
    private String originalWindow = driver.getWindowHandle();

    public void switchToAnotherTab() {
        Set<String> listHandles = driver.getWindowHandles();
        for (String str : listHandles) {
            if (!str.equals(originalWindow)) {
                driver.switchTo().window(str);
            }
        }
    }

    public void closeCurrentTab() {
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public void switchOnPrevoiusTab() {
        Set<String> listHandles = driver.getWindowHandles();
        for (String str : listHandles) {
            if (str.equals(originalWindow)) {
                driver.switchTo().window(str);
            }
        }
    }

    public void getURL(String URL){
        driver.get(URL);
    }

}


