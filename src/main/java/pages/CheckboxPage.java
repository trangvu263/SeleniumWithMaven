package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    public void verifyTextDisplayed(String expectedResult) {
        WebElement result = dr.findElement(By.xpath("//div[@id='result']"));
        String actualResult = result.getText();
        assertEquals(expectedResult, (actualResult));
    }

    public void verifyCheckboxIsChecked(String checkboxName) {
        String normalCheckboxName = checkboxName.toLowerCase();
        WebElement checkbox = dr.findElement(By.cssSelector("#tree-node-" + normalCheckboxName + ""));
        boolean isChecked = checkbox.isSelected();
        assertTrue(isChecked);
    }
}
