package tests.BookStore;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BookStore.LoginPage;
import pages.BookStore.ProfilePage;
import tests.TestCase;

import static org.testng.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;

public class LoginTest extends TestCase {
    @Test(dataProvider = "LoginData")
    public void testLogin(String userName, String password, String expectedErrorMsg) throws InterruptedException {
        LoginPage loginPage = new LoginPage(testBase.driver);
        loginPage.openLoginPage();
//        String user = "Trang";
//        String pass = "abc@1234";
//        String expectedErrorMsg = "Invalid username or password!";
        WebDriver drLogin = loginPage.testBase.driver;
        loginPage.login(userName, password);
        Thread.sleep(5000);
        if(expectedErrorMsg.equalsIgnoreCase("")) {
            ProfilePage profilePage = new ProfilePage(drLogin);
            String actualUserNameValue = profilePage.testBase.getTextByLocator(profilePage.lbUserNameValue);
            Thread.sleep(3000);
            assertEquals(actualUserNameValue, userName);
        } else {
            String actualErrorMsg = loginPage.testBase.getTextByLocator(loginPage.lbErrorMsg);
            assertEquals(actualErrorMsg, expectedErrorMsg);
        }
    }

    @DataProvider(name = "LoginData")
    public String[][] getLoginData() {
        String[][] results = new String[3][3];
        results[0][0] = "sa";
        results[0][1] = "Kofax@01";
        results[0][2] = "";

        results[1][0] = "sa";
        results[1][1] = "Kofax@02";
        results[1][2] = "Invalid username or password!";

        results[2][0] = "sa1";
        results[2][1] = "Kofax@01";
        results[2][2] = "Invalid username or password!";

        return results;

    }
}
