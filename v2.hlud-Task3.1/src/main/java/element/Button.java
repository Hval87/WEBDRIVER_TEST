package element;
import org.openqa.selenium.By;

public class Button extends BaseElement {
    private By locator;
    private String name;

    public Button(By locator, String name) {
        super(locator,name);
        this.locator=locator;
        this.name=name;
    }

}
