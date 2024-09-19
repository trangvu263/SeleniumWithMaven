package tests;

import org.testng.annotations.Test;
import pages.*;

import static common.TestBase.driver;

public class PracticeFormTest extends TestCase {

    @Test
    public void inputSuccessfully() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        TextboxPage textboxPage = new TextboxPage(driver);

        homePage.clickElements("Forms");
        elementsPage.clickElement("Practice Form");
        practiceFormPage.inputName("First Name", "Tracy");
        practiceFormPage.inputName("Last Name", "Phan");
        practiceFormPage.inputText("Email", "abc@gmail.com");
        practiceFormPage.selectGender("Male");
        practiceFormPage.inputText("Mobile", "0123456789");
        practiceFormPage.inputDate("15 September 1998");
        practiceFormPage.selectSubjects("Math, Chemistry");
        practiceFormPage.selectCheckbox("Sports, Music");
        practiceFormPage.uploadPicture("/resources/image.png");
        practiceFormPage.inputText("Current Address", "Cornelia Street");
        practiceFormPage.inputStateCity("Select State", "Haryana");
        practiceFormPage.inputStateCity("Select City", "Panipat");
        textboxPage.clickSubmit();

    }
}
