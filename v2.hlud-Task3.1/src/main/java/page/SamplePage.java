package page;

import element.PageLabel;
import org.openqa.selenium.By;

public class SamplePage extends BasePage {

    private static By UNIQUE_LOCATOR= By.xpath("//h1[@id='sampleHeading']");
    public SamplePage() {
        super(UNIQUE_LOCATOR, "links sample page");
    }
    public boolean isPageOpen(){
        return super.isPageOpen();
    }
}
