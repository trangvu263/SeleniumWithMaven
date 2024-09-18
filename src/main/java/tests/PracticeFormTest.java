package tests;

import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import static common.TestBase.driver;

public class PracticeFormTest extends TestCase {

    @Test
    public void inputSuccessfully() {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        CheckboxPage checkboxPage = new CheckboxPage(driver);
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

        homePage.clickElements("Forms");
        elementsPage.clickElement("Practice Form");
        practiceFormPage.inputName("First Name", "Tracy");
        practiceFormPage.inputName("Last Name", "Phan");
        practiceFormPage.inputText("Email", "abc@gmail.com");
        practiceFormPage.selectGender("Male");
        practiceFormPage.inputText("Mobile", "0123456789");
        practiceFormPage.inputDate("15 September 1998");
        practiceFormPage.inputText("Subjects", "Math");
        practiceFormPage.selectCheckbox("Sports", "Music");




        String inputDate = "15 September 1998";

    }
}
