package element;

import org.openqa.selenium.By;

public class Link extends BaseElement {

    private By locator;
    private String name;

    public Link(By locator, String name) {
        super(locator,name);
        this.locator=locator;
        this.name=name;
    }
}
