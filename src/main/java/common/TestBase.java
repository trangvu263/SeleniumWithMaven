package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestBase {
    public static WebDriver driver;
    public void openWeb() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
    }

    public void closeWeb() {
        driver.quit();
    }

    public void inputTextById(By txtInput, String value) {
        WebElement firstName = driver.findElement(txtInput);
        firstName.sendKeys(value);
    }

    public void selectRadioButtonByXpath(String radioXpath, String radioValue) {
        if(!radioValue.isEmpty() || !radioValue.isBlank()) {
            String newXpath = radioXpath.replace("{@param}", radioValue);
            WebElement radioButton = driver.findElement(By.xpath(newXpath));
            radioButton.click();
        }
    }

    public void inputMultiValuesToComboBox(By comboLocator, String comboValue) {
        if(!comboValue.isEmpty() || !comboValue.isBlank()) {
            String[] values = comboValue.split(",");
            WebElement valueField = driver.findElement(comboLocator);
            valueField.click();
            for (String input : values) {
                valueField.sendKeys(input.trim());
                valueField.sendKeys(Keys.ENTER);
            }
        }
    }

    public void selectCheckboxByXpath(String checkBoxLocator, String checkBoxValue) {
        if(!checkBoxValue.isEmpty() || !checkBoxValue.isBlank()) {
            String[] checkBoxValues = checkBoxValue.split(",");
            for(String input: checkBoxValues) {
                String newXpath = checkBoxLocator.replace("{@param}", input.trim());
                WebElement checkBoxButton = driver.findElement(By.xpath(newXpath));
                checkBoxButton.click();
            }
        }
    }

    public void clickById(By id) {
        WebElement fieldClick = driver.findElement(id);
        fieldClick.click();
    }

    public void selectDrListByXpath(String xpath, String drValue) {
        WebElement drList = driver.findElement(By.xpath(xpath));
        Select drListSelect = new Select(drList);
        drListSelect.selectByVisibleText(drValue);
    }

    public void clickByXpath(String xpath, String input) {
        String newXpath = xpath.replace("@{param}", input.trim());
        WebElement element = driver.findElement(By.xpath(newXpath));
        element.click();
    }

    public void uploadById(By id, String link) {
        driver.findElement(id).sendKeys(System.getProperty("user.dir") + link);
    }

    public String getTableActualValue(String rowXpath, String rowValueXpath) {
        List<WebElement> row = driver.findElements(By.xpath(rowXpath));
        String actualRowValue = null;
        for (int i = 1; i <= row.size(); i++) {
            String n = Integer.toString(i);
            String newXpath = rowValueXpath.replace("{@param}", n);
            WebElement elementValue = driver.findElement(By.xpath(newXpath));
            actualRowValue = elementValue.getText();
        }
        return actualRowValue;
    }
}


