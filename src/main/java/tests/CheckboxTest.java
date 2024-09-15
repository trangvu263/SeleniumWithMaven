package tests;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextboxPage;

import static common.TestBase.driver;

public class CheckboxTest extends TestCase {
    @Test
    public void testCheckbox() {
        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = new ElementsPage(testBase.driver);
        CheckboxPage checkboxPage = new CheckboxPage(testBase.driver);

        homePage.clickElements();
        elementsPage.clickElement("Check Box");
        checkboxPage.selectCheckbox("Home");
        checkboxPage.clickOnExpandIcon("Home");
        checkboxPage.verifyTextDisplayed("You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");
        checkboxPage.verifyCheckboxIsChecked("Desktop");
        checkboxPage.verifyCheckboxIsChecked("Documents");
        checkboxPage.verifyCheckboxIsChecked("Downloads");
    }

}
