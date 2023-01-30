package page;

import element.*;

import util.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RegistrationForm extends BasePage {

    private static By UNIQUE_ELEMENT_LOCATOR = By.xpath("//div[@id='registration-form-modal']");
    private static By ROW_LIST =By.xpath("//div[@role='row']");

    private Input firstNameInp = new Input(By.xpath("//input[@id='firstName']"), "first name input");
    private Input lastNameInp = new Input(By.xpath("//input[@id='lastName']"), "last name input");
    private Input emailInp = new Input(By.xpath("//input[@id='userEmail']"), "email input");
    private Input ageInp = new Input(By.xpath("//input[@id='age']"), "age input");
    private Input salaryInp = new Input(By.xpath("//input[@id='salary']"), "salary input");
    private Input departmentInp = new Input(By.xpath("//input[@id='department']"), "department input");

    private Button submitBTN = new Button(By.xpath("//button[@id='submit']"), "submit button");
    private Table usersInfoTBL=new Table(By.xpath("//div[@class='rt-table']"),"users table");

    public RegistrationForm() {
        super(UNIQUE_ELEMENT_LOCATOR, "registration form");
    }

    public boolean isPageOpen() {
        boolean result = super.isPageOpen();
        return result;
    }

    public void inputFirstName(String firstName) {
        firstNameInp.sendText(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameInp.sendText(lastName);
    }

    public void inputEmail(String email) {
        emailInp.sendText(email);
    }

    public void inputAge(int age) {
        ageInp.sendText(String.valueOf(age));
    }

    public void inputSalary(int salary) {
        salaryInp.sendText(String.valueOf(salary));
    }

    public void inputDepartment(String department) {
        departmentInp.sendText(department);
    }

    public void fillData(User user) {
        inputFirstName(user.getFirstName());
        inputLastName(user.getLastName());
        inputEmail(user.getEmail());
        inputAge(user.getAge());
        inputSalary(user.getSalary());
        inputDepartment(user.getDepartment());
    }

    public void clickSubmitBTN() {
        submitBTN.clickInterceptedElement();
    }

    public boolean isDataPresenrInTable(User user){
        boolean result=false;
        List<WebElement> rows=usersInfoTBL.getRows();
        for (WebElement row : rows) {
            String userInfo = row.getAttribute("innerText").replace("\n", " ");
            if (userInfo.contains(user.getFirstName())
                    && userInfo.contains(user.getLastName())
                    && userInfo.contains(user.getEmail())) {
               result=true;
               break;
            }
        }
        return result;
    }

    public void deleteRowWthData(User user) {

        List<WebElement> rows=usersInfoTBL.getRows();
        for (WebElement row : rows) {
            String userInfo = row.getAttribute("innerText").replace("\n", " ");

            if (userInfo.contains(user.getFirstName())
                    && userInfo.contains(user.getLastName())
                    && userInfo.contains(user.getEmail())) {
                usersInfoTBL.clickToDeleteRow(row);
            }
        }
    }

}
