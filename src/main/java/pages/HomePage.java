package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {


    public HomePage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void clickElements(String elementName) {
        String elementXpath = "//h5[contains(text(), '" + elementName + "')]";
        WebElement elementsLink = dr.findElement(By.xpath(elementXpath));
        elementsLink.click();
    }
}
