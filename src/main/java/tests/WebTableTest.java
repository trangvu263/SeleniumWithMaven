package tests;

import org.testng.annotations.Test;
import pages.WebTablePage;
import tests.models.EmployeeRegister;

public class WebTableTest extends TestCase {

    @Test
    public void search() throws InterruptedException {
        WebTablePage webTablePage = new WebTablePage(testBase.driver);
        webTablePage.openWebTablePage();
        testBase.inputText(webTablePage.searchXpath, "ra");
//        webTablePage.isFirstNameChecked("ie");
        System.out.println(webTablePage.isFirstNameChecked("ra"));
        Thread.sleep(5000);
    }
}
