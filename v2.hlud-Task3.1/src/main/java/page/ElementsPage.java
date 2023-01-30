package page;

import element.Button;
import org.openqa.selenium.By;

public class ElementsPage extends BasePage {
    private SideBarPage sideBarPage = new SideBarPage();

    private static final By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[contains(text(),'Elements') and @class]");
    private static final By WEB_TABLE_BTN_LOCATOR =By.xpath("//div[@class='element-list collapse show']//li[@id='item-3']");

    private Button webTableBTN = new Button(WEB_TABLE_BTN_LOCATOR, "web table button");

    public ElementsPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "elements page");
    }

    public boolean isPageOpen() {
        return super.isPageOpen();
    }

    public void clickToTablesButton() {
        sideBarPage.clickToWebTablesBTN();

    }
}
