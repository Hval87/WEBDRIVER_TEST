package page;

import element.Button;
import element.PageLabel;
import org.openqa.selenium.By;
import util.DriverManager;


public class MainPage extends BasePage {

    private Button alertsFrameWindowBTN = new Button(MAIN_PAGE_ALARM_FRAME_WND_BTN, "alert frames and window button");
    private Button elementsBtn = new Button(MAIN_PAGE_ELEMENTS_BTN, "elements button");

    public static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[@class='category-cards']");
    public static final By MAIN_PAGE_ALARM_FRAME_WND_BTN =By.xpath("//div[@class='card mt-4 top-card'][3]//div[@class='card-body']");
    public static final By MAIN_PAGE_ELEMENTS_BTN =By.xpath("//div[@class='card mt-4 top-card'][1]//div[@class='card-body']");


    public MainPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "Main page");
        driver = DriverManager.createDriver();

    }


    public boolean isPageOpen() {
        boolean result = super.isPageOpen();
        return result;
    }

    public void clickToElementBTN() {
        elementsBtn.clickInterceptedElement();
    }

    public MainPage clickToAlarmFrAndWindBTN() {
        alertsFrameWindowBTN.clickInterceptedElement();
        return this;
    }

}
