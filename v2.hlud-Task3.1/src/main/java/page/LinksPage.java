package page;

import element.Link;
import org.openqa.selenium.By;

public class LinksPage extends BasePage {

    private static By UNIQUE_ELEMENT_LOCATOR =By.xpath("//div[contains(text(),'Links') and @class] ");
    private SideBarPage sideBarPage = new SideBarPage();
    private Link homeLNK = new Link(By.xpath("//a[@id='simpleLink']"), "home link page");

    public LinksPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "links page");
    }

    public boolean isPageOpen() {

        return super.isPageOpen();
    }

    public void clickToHomeLNK() {
        homeLNK.clickToElement();
    }


}
