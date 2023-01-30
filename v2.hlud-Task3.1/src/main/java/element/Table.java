package element;

import actions.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class Table  {
    private By locator;
    private String name;
    private WebDriver driver = DriverManager.createDriver();
    private WebElement cell;

    private static By LOCATOR_FOR_CELL=By.xpath(".//div[contains(@class,'rt-td')]");
    private static By LOCATOR_FOR_ROWS=By.xpath("//div[@class='rt-tr-group']");
    private static By LOCATOR_FOR_DELETE_ROW=By.xpath(".//span[contains(@id,'delete-record-')]");

    public Table(By locator, String name) {
        this.name = name;
        this.locator = locator;
    }

    public List<WebElement> getRows() {
        List<WebElement> rows = driver.findElements(LOCATOR_FOR_ROWS);
        return rows;
    }

    public void clickToDeleteRow(WebElement row){
        cell=row.findElement(LOCATOR_FOR_DELETE_ROW);
        JSUtils.JSclick(cell);
    }
}
