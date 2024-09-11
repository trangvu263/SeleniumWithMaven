package tests;

import common.TestBase;
import org.junit.Test;
import pages.ElementsPage;
import pages.HomePage;

public class TextboxTest extends TestBase {
    @Test
    public void submitSuccessfully() {
        openWeb();
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);

        homePage.clickElements();
        elementsPage.clickElementGroup();



    }
}
