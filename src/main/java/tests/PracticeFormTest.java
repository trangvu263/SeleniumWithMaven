package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static common.TestBase.driver;

public class PracticeFormTest extends TestCase {

    @Test
    public void inputSuccessfully(){
        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        TextboxPage textboxPage = new TextboxPage(driver);

        homePage.clickElements("Forms");
        elementsPage.clickElement("Practice Form");

        testBase.inputTextById(practiceFormPage.txtFirstName, "Tracy");
        testBase.inputTextById(practiceFormPage.txtLastName, "Phan");
        testBase.inputTextById(practiceFormPage.txtEmail, "abc@gmail.com");
        testBase.selectRadioButtonByXpath(practiceFormPage.genderXpath, "Male");
        testBase.inputTextById(practiceFormPage.txtMobile, "0123456789");
        testBase.inputMultiValuesToComboBox(practiceFormPage.cbSubjects,"Maths, English");
        testBase.selectCheckboxByXpath(practiceFormPage.hobbiesXpath, "Sports, Music");

//
//        practiceFormPage.inputName("First Name", "Tracy");
//        practiceFormPage.inputName("Last Name", "Phan");
//        practiceFormPage.inputText("Email", "abc@gmail.com");
//        practiceFormPage.selectGender("Male");
//        practiceFormPage.inputText("Mobile", "0123456789");
        practiceFormPage.inputDate("15 September 1998");
        testBase.inputMultiValuesToComboBox(practiceFormPage.cbSubjects, "Math, Chemistry");
//        practiceFormPage.selectSubjects("Math, Chemistry");
//        practiceFormPage.selectCheckbox("Sports, Music");
//        practiceFormPage.uploadPicture("/resources/image.png");
        testBase.uploadById(practiceFormPage.uploadId, "/resources/image.png");
//        practiceFormPage.inputText("Current Address", "Cornelia Street");
//        practiceFormPage.inputStateCity("Select State", "Haryana");
//        practiceFormPage.inputStateCity("Select City", "Panipat");
//        textboxPage.clickSubmit();
        testBase.inputTextById(practiceFormPage.currentAddressId, "Cornelia Street");
        testBase.inputMultiValuesToComboBox(practiceFormPage.stateXpath, "Haryana");
        testBase.inputMultiValuesToComboBox(practiceFormPage.cityXpath, "Panipat");
        testBase.getTableActualValue(practiceFormPage.tableResultXpath, "Tracy");
        Assert.assertEquals(practiceFormPage.getFormResult(), "Tracy");

    }
}
