package pages;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablePage extends Page {

    public WebTablePage(WebDriver driverWeb) {
        super(driverWeb);
    }

    TestBase testBase = new TestBase();

    public By searchXpath = By.id("searchBox");
    public String columnXpath = "//div[@role='columnheader']";
    public String rowXpath = "";
}
