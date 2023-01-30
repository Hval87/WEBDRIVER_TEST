import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.AllertsPage;
import page.FramesPage;
import page.MainPage;
import page.NestedFramesPage;
import util.BrowserHandleUtil;
import util.DataManager;

public class Test2 extends BaseTest.BaseTest {
    final static Logger logger = Logger.getLogger(Test2.class);
    private MainPage mainPage;
    private AllertsPage allertsPage;
    private NestedFramesPage nestedFramesPage;
    private FramesPage framesPage;

    @Test
    public void test() {
        logger.info("test 2  is running");
        logger.info("step1- navigate to main page");
        BrowserHandleUtil browserHandleUtil=new BrowserHandleUtil();
        browserHandleUtil.getURL(DataManager.getConfigDataByName("startPage"));
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "page is not open");

        logger.info("step2- click to Alerts Frame and Window button. In a menu click Nested Frames");
        mainPage.clickToAlarmFrAndWindBTN();
        allertsPage = new AllertsPage();
        Assert.assertTrue(allertsPage.isPageOpen(), "page is still closed");
        allertsPage.clickToNestedFrameButton();

        nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.checkIfPageIsOpen(),"page is not open");
        Assert.assertEquals(nestedFramesPage
                .getTextFromParentFrame(), "Parent frame", "parents frame absent on the page");
        Assert.assertEquals(nestedFramesPage
                .getTextFromChildFrame(), "Child Iframe", "Child frame is absent on the page");

        logger.info("select Frames options in a left menu");
        nestedFramesPage.clickOnFrameBTN();
        framesPage = new FramesPage();
        Assert.assertTrue(framesPage.checkIfPageIsOpen(), "page is not open");
        String frameTest1 = framesPage.getTextFromFrame(1);
        String frameTest2 = framesPage.getTextFromFrame(2);
        Assert.assertEquals(frameTest1, frameTest2, "elements are noe equals");
        logger.info("test2 complited");


    }

}
