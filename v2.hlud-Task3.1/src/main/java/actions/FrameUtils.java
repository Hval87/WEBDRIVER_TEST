package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import util.DriverManager;
import util.Waiting;

import java.time.Duration;

public class FrameUtils {
    private WebDriver driver = DriverManager.createDriver();
    private Waiting waiting;
    final static Logger logger = Logger.getLogger(FrameUtils.class);


    public void switchFrame(By iframeLocator) {
        logger.trace("switch frames");
        waiting = new Waiting();
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(iframeLocator)));


        driver.switchTo().frame(waiting.waitVisibility(driver.findElement(iframeLocator)));


    }

    public String getTextFromFrame(By locator4text) {
        logger.trace("get text from current frame");
        WebElement element = waiting.waitVisibility(driver.findElement(locator4text));
        String text = element.getText();
        return text;
    }
    public String switchToFrameAndGetText(By frameLocator, By textLocator){
        switchFrame(frameLocator);
        String frameText = getTextFromFrame(textLocator);
        switchToDefaultFrame();
        return frameText;
    }


    public void switchToDefaultFrame() {
        logger.trace("switch to default frame");
        driver.switchTo().defaultContent();
    }

}
