package tests;

import common.TestBase;
import org.junit.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextboxPage;

public class TextboxTest extends TestBase {

    //TC01
    @Test
    public void submitSuccessfully() {
        openWeb();

        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        TextboxPage textboxPage = new TextboxPage(driver);

        homePage.clickElements();
        elementsPage.clickTextbox();
        textboxPage.inputFullName("Nguyen Van A");
        textboxPage.inputEmail("abc@gmail.com");
        textboxPage.inputCurrentAddress("No 1, XYZ Street");
        textboxPage.inputPermanentAddress("No 123, QWERTY Street");
        textboxPage.clickSubmit();
        textboxPage.verifyTextResult("Name:Nguyen Van A\n" +
                "Email:abc@gmail.com\n" +
                "Current Address :No 1, XYZ Street\n" +
                "Permananet Address :No 123, QWERTY Street");

        closeWeb();
    }

    //TC02
    @Test
    public void TC02() {
        openWeb();

        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        TextboxPage textboxPage = new TextboxPage(driver);

        homePage.clickElements();
        elementsPage.clickTextbox();
        textboxPage.inputFullName("Nguyen Van A");
        textboxPage.inputEmail("abcgmail.com");
        textboxPage.inputCurrentAddress("No 1, XYZ Street");
        textboxPage.inputPermanentAddress("No 123, QWERTY Street");
        textboxPage.clickSubmit();
        textboxPage.verifyReturnNoResult();
        textboxPage.verifyEmailBorder("#495057");

        closeWeb();
    }

    //TC03
    @Test
    public void TC03() {
        openWeb();

        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        TextboxPage textboxPage = new TextboxPage(driver);

        homePage.clickElements();
        elementsPage.clickTextbox();
        textboxPage.inputFullName("Nguyen Van A");
        textboxPage.inputEmail("abc@gmail");
        textboxPage.inputCurrentAddress("No 1, XYZ Street");
        textboxPage.inputPermanentAddress("No 123, QWERTY Street");
        textboxPage.clickSubmit();
        textboxPage.verifyReturnNoResult();
        textboxPage.verifyEmailBorder("#495057");

        closeWeb();
    }
}
