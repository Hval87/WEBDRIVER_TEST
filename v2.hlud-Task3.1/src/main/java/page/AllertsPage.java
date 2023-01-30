package page;

import actions.AlertUtils;
import element.Button;
import org.openqa.selenium.By;

public class AllertsPage extends BasePage {
    private Button alertButton = new Button(By.xpath("//button[@id='alertButton']"), "alert button");
    private Button confirmAlertButton = new Button(By.xpath("//button[@id='confirmButton']"), "confirm box button");
    private Button alertWithPromtButton = new Button(By.xpath("//button[@id='promtButton']"), "alert with promt button");
    private SideBarPage sideBarPage = new SideBarPage();
    private AlertUtils alertUtils = new AlertUtils();

    private static By FIELD_FOR_ALERT_TEXT_LOCATOR = By.xpath("//span[@id='promptResult']");
    private static By UNIQUE_NAME_OF_PAGE_LOCATOR = By.xpath("//div[@class='main-header']");
    private static By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[contains(text(),'Alerts') and @class] ");

    public AllertsPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "Frames page");
    }

    public void clickToSeeAlert() {
        alertButton.clickToElement();
    }

    public void ClickToAllertsBtn() {
        sideBarPage.clickToAlertBtn();
    }

    public void clickToAcceptAlert() {
        alertUtils.clickAcceptOnAlert();
    }

    public void clickToAllertsWithConfirmBox() {
        confirmAlertButton.clickInterceptedElement();
    }

    public void clickAcceptAlertWithConfirm() {
        alertUtils.clickAcceptOnAlert();
    }

    public void clickToAlertWithPromtBTN() {
        alertWithPromtButton.clickInterceptedElement();
    }

    public void inputTextAndAcceptAllert(String text) {
        alertUtils.inputTextAndClickAccept(text);
    }

    public boolean checkAlertIsPresent() {
        return alertUtils.isAlertPresent();
    }

    public String getAlertText() {
        return alertUtils.getAlertText();
    }

    public boolean textContainedInAlert(String text) {
        boolean result = super.textContainedInPage(text, FIELD_FOR_ALERT_TEXT_LOCATOR);
        return result;
    }

    public boolean isPageOpen() {
        boolean result = super.isPageOpen();
        return result;
    }

    public void clickToNestedFrameButton() {
        sideBarPage.clickToNestedFrameBTN();
    }


}
