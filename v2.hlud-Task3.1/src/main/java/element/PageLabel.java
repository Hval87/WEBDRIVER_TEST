package element;


import org.openqa.selenium.By;

public class PageLabel extends BaseElement {
    private static String LOCATOR="//div[@class='main-header']";
    public PageLabel(By locator, String name) {
        super(locator,name);
    }

}
