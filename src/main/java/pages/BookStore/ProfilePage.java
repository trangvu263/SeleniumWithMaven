package pages.BookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Page;

public class ProfilePage extends Page {

    public ProfilePage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public By lbUserNameValue = By.id("userName-value");
}
