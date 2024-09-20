package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElementsPage extends Page {
    public ElementsPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void clickElement(String elementName) {
        String elementXpath = "//span[text()='" + elementName + "']";
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath(elementXpath))));
        element.click();
    }
}
