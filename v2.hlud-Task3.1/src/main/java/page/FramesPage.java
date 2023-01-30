package page;
import actions.FrameUtils;
import org.openqa.selenium.By;

public class FramesPage extends BasePage {
    private static By UNIQUE_ELEMENT_LOCATOR= By.xpath("//div[contains(text(),'Frames') and @class] ");
    private static By UNIQUE_NAME_OF_PAGE_LOCATOR =By.xpath("//div[@class='main-header']");
    //private static By FRAME_LOCATOR =By.xpath("//div[@id='frame1Wrapper']//iframe");
    private static By FRAME2_LOCATOR =By.xpath("//div[@id='frame2Wrapper']//iframe");
    private static By TEXT_IN_FRAME1_LOCATOR =By.id("sampleHeading");
    private static FrameUtils frameUtils = new FrameUtils();
    private String dynLocator="//div[@id='frame%sWrapper']//iframe";

    public FramesPage() {
        super(UNIQUE_ELEMENT_LOCATOR,"Frames page");
    }
    public boolean checkIfPageIsOpen() {
        boolean result = super.isPageOpen();
        return result;
    }

    public String getTextFromFrame(int frameNumber) {
        By FRAME_LOCATOR =By.xpath(String.format(dynLocator, frameNumber));
        String frameText =frameUtils.switchToFrameAndGetText(FRAME_LOCATOR,TEXT_IN_FRAME1_LOCATOR);
        return frameText;
    }

    public String getTextFromFrame2() {
        String frameText =frameUtils.switchToFrameAndGetText(FRAME2_LOCATOR,TEXT_IN_FRAME1_LOCATOR);
        return frameText;
    }
}
