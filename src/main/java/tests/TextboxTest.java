package tests;

import pages.ElementsPage;
import pages.HomePage;
import pages.TextboxPage;
import org.testng.annotations.Test;

public class TextboxTest extends TestCase {

    //TC01
    @Test(groups = "happy case")
    public void submitSuccessfully() {
        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = new ElementsPage(testBase.driver);
        TextboxPage textboxPage = new TextboxPage(testBase.driver);

        homePage.clickElements();
        elementsPage.clickElement("Text Box");
        textboxPage.inputFullName("Nguyen Van A");
        textboxPage.inputEmail("abc@gmail.com");
        textboxPage.inputCurrentAddress("No 1, XYZ Street");
        textboxPage.inputPermanentAddress("No 123, QWERTY Street");
        textboxPage.clickSubmit();
        textboxPage.verifyTextResult("Name:Nguyen Van A\n" +
                "Email:abc@gmail.com\n" +
                "Current Address :No 1, XYZ Street\n" +
                "Permananet Address :No 123, QWERTY Street");
    }

    //TC02 No @ email
    @Test(groups= "validation cases")
    public void TC02() {
        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = new ElementsPage(testBase.driver);
        TextboxPage textboxPage = new TextboxPage(testBase.driver);

        homePage.clickElements();
        elementsPage.clickElement("Text Box");
        textboxPage.inputFullName("Nguyen Van A");
        textboxPage.inputEmail("abcgmail.com");
        textboxPage.inputCurrentAddress("No 1, XYZ Street");
        textboxPage.inputPermanentAddress("No 123, QWERTY Street");
        textboxPage.clickSubmit();
        textboxPage.verifyReturnNoResult();
        textboxPage.verifyEmailBorder("#495057");
    }

    //TC03 No Domain
    @Test
    public void TC03NoDomain() {
        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = new ElementsPage(testBase.driver);
        TextboxPage textboxPage = new TextboxPage(testBase.driver);

        homePage.clickElements();
        elementsPage.clickElement("Text Box");
        textboxPage.inputFullName("Nguyen Van A");
        textboxPage.inputEmail("abc@gmail");
        textboxPage.inputCurrentAddress("No 1, XYZ Street");
        textboxPage.inputPermanentAddress("No 123, QWERTY Street");
        textboxPage.clickSubmit();
        textboxPage.verifyReturnNoResult();
        textboxPage.verifyEmailBorder("#495057");
    }
}
