package tests;

import org.testng.Assert;
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

        String expectedResult =
                "Student Name = Tracy Phan\n" +
                        "Student Email = abc@gmail.com\n" +
                        "Gender = Male\n" +
                        "Mobile = 0123456789\n" +
                        "Date of Birth = 15 September,1998\n" +
                        "Subjects = Maths, English\n" +
                        "Hobbies = Sports, Music\n" +
                        "Picture = image.png\n" +
                        "Address = Cornelia Street\n" +
                        "State and City = Haryana Panipat";

        testBase.inputTextById(practiceFormPage.txtFirstName, "Tracy");
        testBase.inputTextById(practiceFormPage.txtLastName, "Phan");
        testBase.inputTextById(practiceFormPage.txtEmail, "abc@gmail.com");
        testBase.selectRadioButtonByXpath(practiceFormPage.genderXpath, "Male");
        testBase.inputTextById(practiceFormPage.txtMobile, "0123456789");
        practiceFormPage.inputDate("15 September 1998");
        testBase.inputMultiValuesToComboBox(practiceFormPage.cbSubjects,"Maths, English");
        testBase.selectCheckboxByXpath(practiceFormPage.hobbiesXpath, "Sports, Music");
        testBase.uploadById(practiceFormPage.uploadId, "/resources/image.png");
        testBase.inputTextById(practiceFormPage.currentAddressId, "Cornelia Street");
        testBase.inputMultiValuesToComboBox(practiceFormPage.stateXpath, "Haryana");
        testBase.inputMultiValuesToComboBox(practiceFormPage.cityXpath, "Panipat");
        textboxPage.clickSubmit();
        Assert.assertEquals(practiceFormPage.getFormResult(), testBase.getExpectedTableValue(expectedResult));
    }
}
