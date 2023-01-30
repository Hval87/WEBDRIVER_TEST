package util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Waiting {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waiting() {
        this.driver = DriverManager.createDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(String.valueOf(DataManager.getConfigDataByName("implWaitTime")))));
    }

    public WebElement waitVisibility(WebElement element){

        return wait.until(ExpectedConditions
                .visibilityOf(element));
    }

    public WebElement waitClickability(WebElement element){

        return wait.until(ExpectedConditions
                .elementToBeClickable(element));
    }
    public Alert waitUntilAllertIsPresent(){
        return wait.until(alertIsPresent());
    }
}