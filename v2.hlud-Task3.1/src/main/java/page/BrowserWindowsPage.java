package page;

import element.Button;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BasePage {

    private SideBarPage sideBarPage = new SideBarPage();
    private static By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[contains(text(),'Browser Windows') and @class] ");
    private Button newTabBTN = new Button(By.xpath("//button[@id='tabButton']"), "new tab button");

    public BrowserWindowsPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "browser page");
    }

    public boolean isPageOpen() {
        return super.isPageOpen();
    }

    public void clickToNewTab() {
        newTabBTN.clickInterceptedElement();
    }

    public void clickElementBTN() {
        sideBarPage.clickToElementsBTN();
    }

    public void clickLinksBTN() {
        sideBarPage.clickToLinksBTN();
    }


}
