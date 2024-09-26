package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.ElementsPage;
import pages.HomePage;

import static common.TestBase.driver;

public class CheckboxTest extends TestCase {
    @Test
    public void testCheckbox() {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        CheckboxPage checkboxPage = new CheckboxPage(driver);

        homePage.clickElements("Elements");
        elementsPage.clickElement("Check Box");
        checkboxPage.selectCheckbox("Home");
        checkboxPage.clickOnExpandIcon("Home");
        Assert.assertEquals(checkboxPage.getTextDisplayed(), "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile");
        Assert.assertTrue(checkboxPage.CheckboxIsChecked("Desktop"));
    }

}
