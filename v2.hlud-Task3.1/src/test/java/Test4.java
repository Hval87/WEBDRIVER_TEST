import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.*;
import util.BrowserHandleUtil;
import util.DataManager;

public class Test4 extends BaseTest {
    final  static Logger logger=Logger.getLogger(Test4.class);
    private MainPage mainPage;
    private AlertsFrameWindowPage alertsFrameWindowPage;
    private BrowserWindowsPage browserWindowsPage;
    private LinksPage linksPage;
    private SamplePage samplePage;

    @Test
    public void test4() {
        logger.info("test4 is started");
        logger.info("navigate to main page");
        BrowserHandleUtil browserHandleUtil=new BrowserHandleUtil();
        browserHandleUtil.getURL(DataManager.getConfigDataByName("startPage"));
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(),"main page is still closed");

        logger.info("click on Alert Frame and Window BTN, in the menu click oa browser windows button");
        mainPage.clickToAlarmFrAndWindBTN();
        alertsFrameWindowPage = new AlertsFrameWindowPage();
        alertsFrameWindowPage.clickToBrowserWindowsBTN();
        browserWindowsPage = new BrowserWindowsPage();
        Assert.assertTrue(browserWindowsPage.isPageOpen(),"browser page is closed");

        logger.info("click on new tab button");
        browserWindowsPage.clickToNewTab();
        browserHandleUtil.switchToAnotherTab();
        samplePage=new SamplePage();
        Assert.assertTrue(samplePage.isPageOpen(),"sample page is still closed");

        logger.info("close current tab");
        browserHandleUtil.closeCurrentTab();
        browserHandleUtil.switchToAnotherTab();
        Assert.assertTrue(browserWindowsPage.isPageOpen(),"browser page  is still closed");

        logger.info("in the menu on the left click Elements->links button ");
        browserWindowsPage.clickElementBTN();
        browserWindowsPage.clickLinksBTN();
        linksPage=new LinksPage();
        Assert.assertTrue(linksPage.isPageOpen(),"links page is closed");

        logger.info("click on Home button");
        linksPage.clickToHomeLNK();
        browserHandleUtil.switchToAnotherTab();
        mainPage=new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(),"main page is closed");
        browserHandleUtil.switchOnPrevoiusTab();
        Assert.assertTrue(linksPage.isPageOpen(),"links page is closed");
        logger.info("continue to previous tab");
        logger.info("Test4 ended");


    }
}
