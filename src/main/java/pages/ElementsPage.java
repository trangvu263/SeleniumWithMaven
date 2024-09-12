package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElementsPage extends Page {
    public ElementsPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void clickElementGroup() {
        WebElement element = dr.findElement(By.xpath("//div[text()='Elements']"));
        element.click();
    }

    public void clickTextbox() {
        WebElement textboxElement = wait.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//span[text()='Text Box']"))));
        textboxElement.click();
    }
}
