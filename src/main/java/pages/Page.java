package pages;

import common.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BookStore.LoginPage;

import java.time.Duration;

public class Page {
    public WebDriver dr;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public Actions action;
    public TestBase testBase = new TestBase();
    public Page(WebDriver driverWeb) {
        this.dr = driverWeb;
        this.wait = new WebDriverWait(dr, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) dr;
        this.action = new Actions(dr);
    }

    public PracticeFormPage openPraticeForms() {
        dr.navigate().to("https://demoqa.com/automation-practice-form");
        PracticeFormPage praticeForm = new PracticeFormPage(testBase.driver);
        return praticeForm;
    }

    public WebTablePage openWebTablePage() {
        dr.navigate().to("https://demoqa.com/webtables");
        WebTablePage openWebTablePage = new WebTablePage(testBase.driver);
        return openWebTablePage;
    }

    public LoginPage openLoginPage() {
        dr.navigate().to("https://demoqa.com/login");
        LoginPage loginPage = new LoginPage(dr);
        return loginPage;
    }
}