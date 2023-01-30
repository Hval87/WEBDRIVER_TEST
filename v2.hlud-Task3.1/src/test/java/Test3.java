import BaseTest.BaseTest;
import util.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import page.ElementsPage;
import page.MainPage;
import page.RegistrationForm;
import page.WebTablesPage;
import util.BrowserHandleUtil;
import util.DataManager;

public class Test3 extends BaseTest {
    final static Logger logger = Logger.getLogger(Test3.class);
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private WebTablesPage webTablesPage;
    private RegistrationForm registrationForm;

    @DataProvider(name = "userData")
    public Object[][] getDataForTest() {
        Object[][] obj;
        User user1 = DataManager.getTestData().getUsers().get(0);
        User user2 = DataManager.getTestData().getUsers().get(1);
        obj = new Object[][]{{user1}, {user2}};
        return obj;

    }

    @Test(dataProvider = "userData")
    public void test3(User user) {
        logger.info("test is running");
        logger.info("step1- navigate to main page");
        BrowserHandleUtil browserHandleUtil=new BrowserHandleUtil();
        browserHandleUtil.getURL(DataManager.getConfigDataByName("startPage"));
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "page is not open");

        logger.info("step2- click on element button, in the menu click a web table button");
        mainPage.clickToElementBTN();
        elementsPage = new ElementsPage();
        elementsPage.isPageOpen();
        elementsPage.clickToTablesButton();

        logger.info("click on add button");
        webTablesPage = new WebTablesPage();
        webTablesPage.clickToAddBTN();
        registrationForm = new RegistrationForm();

        logger.info("step3- enter data for users № from the table and then click Submit button");
        registrationForm.fillData(user);
        registrationForm.clickSubmitBTN();

        Assert.assertTrue(registrationForm.isDataPresenrInTable(user),"data is not present on the form");
        Assert.assertFalse(registrationForm.isPageOpen(),"form is stil open");
        logger.info("click a delete data in a row which contains data of User №");
        registrationForm.deleteRowWthData(user);
        Assert.assertFalse(registrationForm.isDataPresenrInTable(user),"data is still present on the page");

    }

}
