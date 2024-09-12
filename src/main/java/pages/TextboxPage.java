package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextboxPage extends Page {
    public TextboxPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void inputFullName(String name) {
//        WebElement fullName = wait.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//input[@placeholder='Full Name']"))));

        WebElement fullName = dr.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys(name);
    }

    public void inputEmail(String email) {
        WebElement emailAddress = dr.findElement(By.xpath("//label[text()='Email']/following::div/input"));
        emailAddress.sendKeys(email);
    }

    public void inputCurrentAddress(String curAd) {
        WebElement currentAddress = dr.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAddress.sendKeys(curAd);
    }

    public void inputPermanentAddress(String perAd) {
        WebElement permanentAddress = dr.findElement(By.xpath("//label[text()='Permanent Address']/following::div/textarea"));
        permanentAddress.sendKeys(perAd);
    }

    public void clickSubmit() {
        WebElement submitButton = dr.findElement(By.xpath("//button[text()='Submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }

    public void verifyTextResult(String expectedOutput) {
        WebElement output = wait.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath("//div[@id='output']"))));
        String actualOutput = output.getText();
        assertEquals(expectedOutput, (actualOutput));

    }

    public boolean isResultDisplayed() {
        WebElement output = dr.findElement(By.xpath("//div[@id='output']"));
        boolean isOutputDisplayed = output.isDisplayed();
        return isOutputDisplayed;
    }

    public void verifyReturnNoResult() {
        boolean a = isResultDisplayed();
        assertFalse(a);
    }


        public void verifyEmailBorder(String expectedColor) {
        WebElement emailAddress = dr.findElement(By.xpath("//label[text()='Email']/following::div/input"));
        String cssColor = emailAddress.getCssValue("color");
        String actualColor = Color.fromString(cssColor).asHex();
        assertEquals(expectedColor, (actualColor));
    }
}
