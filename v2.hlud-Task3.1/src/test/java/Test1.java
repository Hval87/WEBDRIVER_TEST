import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.AllertsPage;
import page.MainPage;
import util.BrowserHandleUtil;
import util.DataManager;
import util.StringGenerationUtil;

public class Test1 extends BaseTest {
    final static Logger logger = Logger.getLogger(Test1.class);
    private MainPage mainPage;
    private AllertsPage allertsPage;


    @Test
    public void test() {
        logger.info("test1 is running");
        logger.info("step 1- navigate to main page");
        BrowserHandleUtil browserHandleUtil=new BrowserHandleUtil();
        browserHandleUtil.getURL(DataManager.getConfigDataByName("startPage"));
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "page is not open");

        logger.info("step2- click to Alerts Frame and Window button. In a menu click alerts button");
        mainPage.clickToAlarmFrAndWindBTN();
        allertsPage = new AllertsPage();
        allertsPage.ClickToAllertsBtn();

        logger.info(" click Button to see alert button");
        allertsPage.clickToSeeAlert();
        Assert.assertTrue(allertsPage.checkAlertIsPresent(),"page is not open");

        logger.info("click ok button");
        allertsPage.clickToAcceptAlert();
        Assert.assertFalse(allertsPage.checkAlertIsPresent(), "the alert is still open");

        logger.info("click on On button click, confirm box will appear");
        allertsPage.clickToAllertsWithConfirmBox();
        Assert.assertEquals(allertsPage.getAlertText(), "Do you confirm action?", "alert is not present");

        logger.info(" click on Ok button");
        allertsPage.clickAcceptAlertWithConfirm();
        Assert.assertFalse(allertsPage.checkAlertIsPresent(), "the alert is still open");

        logger.info("click on On button click, promt box will apperar button");
        allertsPage.clickToAlertWithPromtBTN();
        Assert.assertEquals(allertsPage.getAlertText(), "Please enter your name", "alert is not present");
        String text = StringGenerationUtil.getGeneratedString();
        System.out.println(text);

        logger.info("enter randomly generated text? click OK");
        allertsPage.inputTextAndAcceptAllert(text);
        Assert.assertTrue(allertsPage.textContainedInAlert(text), " text from the alert is not displayed on the page");
        Assert.assertFalse(allertsPage.checkAlertIsPresent(), "the alert is still open");

        logger.info("test1 complited");
    }
}
