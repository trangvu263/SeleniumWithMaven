package pages.BookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page;

public class LoginPage extends Page {

    public LoginPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public By txtUserName = By.id("userName");
    public By txtPassword = By.id("password");
    public By btnLogin = By.id("login");
    public By lbErrorMsg = By.id("name");

    public void login(String userName, String password) {
        testBase.inputText(txtUserName, userName);
        testBase.inputText(txtPassword, password);
        testBase.scrollToElement(btnLogin);
        testBase.clickById(btnLogin);
    }
}
