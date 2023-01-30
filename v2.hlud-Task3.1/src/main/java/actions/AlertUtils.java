package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;
import util.DriverManager;
import util.Waiting;

public class AlertUtils {
    private Waiting waiting;
    private WebDriver driver = DriverManager.createDriver();
    final static Logger logger = Logger.getLogger(FrameUtils.class);

    public void clickAcceptOnAlert() {
        logger.trace("click on alert");
        waiting = new Waiting();
        Alert alert = waiting.waitUntilAllertIsPresent();
        alert.accept();
    }

    public void inputTextAndClickAccept(String text) {
        logger.trace("input text and click accept");
        waiting = new Waiting();
        Alert alert = waiting.waitUntilAllertIsPresent();
        alert.sendKeys(text);
        alert.accept();
    }

    public boolean isAlertPresent() {
        try {
            logger.trace("allert present on the page");
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            logger.error(" allert is not present on the page");
            return false;
        }
    }

    public String getAlertText() {

        logger.trace(" get text from allert");
        waiting = new Waiting();
        Alert alert = waiting.waitUntilAllertIsPresent();
        String text = alert.getText();
        return text;
    }

}
