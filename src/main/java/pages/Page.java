package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    public WebDriver dr;
    public WebDriverWait wait;
    public JavascriptExecutor js;


    public Page(WebDriver driverWeb) {
        this.dr = driverWeb;
        this.wait = new WebDriverWait(dr, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) dr;
    }

}
