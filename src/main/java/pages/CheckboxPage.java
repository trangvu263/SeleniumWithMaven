package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage extends Page {
    public CheckboxPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void selectCheckbox(String checkboxName) {
        String checkboxXpath = "//span[text()='" + checkboxName + "']/preceding-sibling::span[@class='rct-checkbox']/*[name()='svg']";
        WebElement checkbox = dr.findElement(By.xpath(checkboxXpath));
        checkbox.click();
    }

    public void clickOnExpandIcon(String name) {
        String expandIconXpath = "//span[text()='" + name + "']/preceding::button[@title='Toggle'][1]";
        WebElement expandIcon = dr.findElement(By.xpath(expandIconXpath));
        expandIcon.click();
    }

    public String getTextDisplayed() {
        List<WebElement> elements = dr.findElements(By.xpath("//div[@id='result']/span"));
        String actualResult = "";
        for (WebElement element : elements) {
            actualResult = actualResult + " " + element.getText();
        }
        return actualResult.trim();
    }

    public boolean CheckboxIsChecked(String checkboxName) {
        String normalCheckboxName = checkboxName.toLowerCase();
        WebElement checkbox = dr.findElement(By.cssSelector("#tree-node-" + normalCheckboxName + ""));
        boolean isChecked = checkbox.isSelected();
        return isChecked;
    }
}
