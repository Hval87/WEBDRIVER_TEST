package page;

import element.Button;
import org.openqa.selenium.By;

public class WebTablesPage extends BasePage {

    private SideBarPage sideBarPage = new SideBarPage();
    private static By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[@class='main-header' and contains(text(),'Web Tables')]");
    private Button addBTN = new Button(By.xpath("//button[@id='addNewRecordButton']"), "add button");

    public WebTablesPage() {
        super(UNIQUE_ELEMENT_LOCATOR, "web table page");
    }

    public boolean isPageOpen() {
        boolean result = super.isPageOpen();
        return result;
    }

    public void clickToAddBTN() {
        addBTN.clickToElement();
    }
}
