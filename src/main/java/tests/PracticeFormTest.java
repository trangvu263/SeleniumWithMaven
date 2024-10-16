package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.models.StudentRegister;

import static common.TestBase.driver;

public class PracticeFormTest extends TestCase {

    @Test
    public void inputSuccessfully() {
//        HomePage homePage = new HomePage(driver);
//        ElementsPage elementsPage = new ElementsPage(driver);

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.openPraticeForms();

        TextboxPage textboxPage = new TextboxPage(driver);
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.firstName = "Tracy";
        studentRegister.lastName = "Phan";
        studentRegister.email = "abc@gmail.com";
        studentRegister.gender = "Male";
        studentRegister.mobilePhone = "0123456789";
        studentRegister.dayOfBirth = "15 September 1998";
        studentRegister.subjects = "Maths, English";
        studentRegister.hobbies = "Sports, Music";
        studentRegister.uploadPicture = "/resources/image.png";
        studentRegister.currentAddress = "Cornelia Street";
        studentRegister.state = "Haryana";
        studentRegister.city = "Panipat";

        practiceFormPage.inputData(studentRegister);

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

        textboxPage.clickSubmit();
        Assert.assertEquals(practiceFormPage.getFormResult(), testBase.getExpectedTableValue(expectedResult));
    }
}
