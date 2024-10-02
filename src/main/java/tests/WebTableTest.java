package tests;

import org.testng.annotations.Test;
import pages.WebTablePage;

public class WebTableTest extends TestCase {

    @Test
    public void search() {
        WebTablePage webTablePage = new WebTablePage(testBase.driver);
        webTablePage.openWebTablePage();
        testBase.inputText(webTablePage.searchXpath, "ie");

    }
}
