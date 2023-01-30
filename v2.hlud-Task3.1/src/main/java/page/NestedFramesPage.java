package page;

import actions.FrameUtils;
import org.openqa.selenium.By;

public class NestedFramesPage extends BasePage {

    private SideBarPage sideBarPage;

    private static By UNIQUE_ELEMENT_LOCATOR= By.xpath("//div[contains(text(),'Nested Frames') and @class] ");
    private static By UNIQUE_NAME_OF_PAGE_LOCATOR =By.xpath("//div[@class='main-header']");
    private static By PARENTS_FRAME_LOCATOR=By.xpath("//div[@id='frame1Wrapper']//iframe");
    private static By CHILD_FRAME_LOCATOR=By.xpath("//iframe");
    private static By LOCATOR_FOR_PARENTS_FRAME_TEXT=By.xpath("//body");
    private static By LOCATOR_FOR_CHILD_TEXT=By.xpath("//body");

    public NestedFramesPage() {
        super(UNIQUE_ELEMENT_LOCATOR,"Nested page");
    }

    public boolean checkIfPageIsOpen() {
        boolean result = super.isPageOpen();
        return result;
    }

    public void clickOnFrameBTN() {
        sideBarPage = new SideBarPage();
        sideBarPage.clickToFramesBTN();
    }

    public String getTextFromChildFrame() {
        FrameUtils frameUtils = new FrameUtils();
        frameUtils.switchFrame(PARENTS_FRAME_LOCATOR);
        frameUtils.switchFrame(CHILD_FRAME_LOCATOR);
        String childText= frameUtils.getTextFromFrame(LOCATOR_FOR_CHILD_TEXT);
        frameUtils.switchToDefaultFrame();
        frameUtils.switchToDefaultFrame();
        return childText;
    }
    public String getTextFromParentFrame(){
        FrameUtils frameUtils =new FrameUtils();
        frameUtils.switchFrame(PARENTS_FRAME_LOCATOR);
        String frameText= frameUtils
                .getTextFromFrame(LOCATOR_FOR_PARENTS_FRAME_TEXT);
        frameUtils.switchToDefaultFrame();
        return frameText;
    }
}









