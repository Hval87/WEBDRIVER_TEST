package BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.*;
import util.*;

import java.time.Duration;

public class BaseTest {
    private static final String IMPLICITY_WAIT_TIME="implWaitTime";
    private WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = DriverManager.createDriver();
        driver.manage().window().maximize();
        int implTime=Integer.parseInt(DataManager.getConfigDataByName(IMPLICITY_WAIT_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implTime));
    }

    @AfterSuite()
    public void tearsDown() {
        driver.quit();
    }
}