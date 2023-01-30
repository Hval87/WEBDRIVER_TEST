package page;

import element.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SideBarPage extends BasePage {
    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[@class='left-pannel']");

    private Button alertBtn = new Button(By.xpath("//div[contains(@class,'show')]//li[@id='item-1']"), "alert button");
    private Button nestedFrameButton = new Button(By.xpath("//div[contains(@class,'show')]//li[@id='item-3']"), "nested frame button");
    private Button frameButton = new Button(By.xpath("//div[contains(@class,'show')]//li[@id='item-2']"), "frame button");
    private Button webTablesButton = new Button(By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']"), "web tables button");
    private Button browserWindowBTN = new Button(By.xpath("//span[text()='Browser Windows']"), "browser Window");
    private Button elementBTN = new Button(By.xpath("//div[contains(text(),'Elements')]//parent::div/parent::span"), "elements button");
    private Button linksBTN = new Button(By.xpath("//span[text()='Links']/.."), "links button");

    public SideBarPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "Side bar");
    }

    public void clickToAlertBtn() {
        alertBtn.getElement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertBtn.getElement());
    }

    public void clickToNestedFrameBTN() {
        nestedFrameButton.clickInterceptedElement();
    }

    public void clickToFramesBTN() {
        frameButton.clickInterceptedElement();
    }

    public void clickToWebTablesBTN() {
        webTablesButton.clickInterceptedElement();
    }

    public void clickToBrowserWindowBTN() {
        browserWindowBTN.clickInterceptedElement();
    }

    public void clickToElementsBTN() {
        elementBTN.clickToElement();
    }

    public void clickToLinksBTN() {
        linksBTN.clickInterceptedElement();
    }

}
