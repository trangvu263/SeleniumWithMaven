package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class PracticeFormTest extends TestCase {

    @Test
    public void inputSuccessfully() {
        String inputDate = "15 September 1998";
        PracticeFormPage practiceForm = new PracticeFormPage(testBase.driver);

    }
}
