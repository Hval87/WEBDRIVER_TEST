package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.log4testng.Logger;

import java.util.List;




public class DriverManager {

    private static WebDriver driver;
    private static final String BROWSER="browser";
    private static final String DRIVER_ARGUMENTS="driverArguments";
    private static final String CHROME="chrome";
    private static final String FIREFOX="firefox";
    static final Logger logger = Logger.getLogger(DriverManager.class);

    private DriverManager() {
    }

    public static WebDriver createDriver() {
        if (driver == null) {
            String browserName = DataManager.getConfigDataByName(BROWSER);
            switch (browserName) {
                case CHROME:

                    logger.trace(" CHROME driver is getting");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(DataManager.getListOfConfigDataByName(DRIVER_ARGUMENTS));
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case FIREFOX:
                    logger.trace(" FIREFOX driver is getting");
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments(DataManager.getListOfConfigDataByName(DRIVER_ARGUMENTS));
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    logger.error("browser is not defined");
                    throw new RuntimeException("browser is not defined");
            }
            return driver;
        } else
            return driver;
    }
}


