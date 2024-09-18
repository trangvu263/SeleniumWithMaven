package tests;

import org.testng.annotations.Test;
import pages.*;

import static common.TestBase.driver;

public class PracticeFormTest extends TestCase {

    @Test
    public void inputSuccessfully() {
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
        practiceFormPage.inputText("Subjects", "Math");
        practiceFormPage.selectCheckbox("Sports, Music");
        practiceFormPage.uploadPicture("https://files.slack.com/files-pri/TDK8XB4AV-F07797GGLGG/download/image.png?origin_team=TDK8XB4AV/image.png");
        practiceFormPage.inputText("Current Address", "Cornelia Street");
        practiceFormPage.inputStateCity("Select State", "Haryana");
        textboxPage.clickSubmit();

    }
}
