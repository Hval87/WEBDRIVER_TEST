package page;

import element.PageLabel;
import org.openqa.selenium.By;


public class AlertsFrameWindowPage extends BasePage {
    private SideBarPage sideBarPage=new SideBarPage();

    private static By UNIQUE_ELEMENT = By.xpath( "//div[contains(text(),'Alerts, Frame & Windows') and @class]");

    public AlertsFrameWindowPage() {
        super(UNIQUE_ELEMENT, "Alert Frame and Window page");
    }
    public void clickToBrowserWindowsBTN(){
        sideBarPage.clickToBrowserWindowBTN();
    }



}
