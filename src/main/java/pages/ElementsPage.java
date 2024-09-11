package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends Page {
    public ElementsPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void clickElementGroup() {
        WebElement element = dr.findElement(By.xpath("//div[text()='Elements']"));
        element.click();
    }
}
