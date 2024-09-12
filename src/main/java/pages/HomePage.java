package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {


    public HomePage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void clickElements() {
        WebElement elementsLink = dr.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
        elementsLink.click();
    }
}
