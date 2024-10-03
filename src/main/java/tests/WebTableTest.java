package tests;

import org.testng.annotations.Test;
import pages.WebTablePage;
import tests.models.EmployeeRegister;

public class WebTableTest extends TestCase {

    @Test
    public void search() {
        WebTablePage webTablePage = new WebTablePage(testBase.driver);
        webTablePage.openWebTablePage();
        testBase.inputText(webTablePage.searchXpath, "ie");

        EmployeeRegister employeeRegister = new EmployeeRegister();

        employeeRegister.firstName = "Cierra";
        employeeRegister.lastName = "Vega";
        employeeRegister.age = "39";
        employeeRegister.email = "cierra@example.com";
        employeeRegister.salary = "10000";
        employeeRegister.department = "Insurance";



    }
}
