package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void openWeb() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
            WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(newXpath)));
            radioButton.click();
        }
    }

    public void inputMultiValuesToComboBox(By comboLocator, String comboValue) {
        if(!comboValue.isEmpty() || !comboValue.isBlank()) {
            String[] values = comboValue.split(",");
            WebElement valueField = driver.findElement(comboLocator);
//            valueField.click();
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
        String newXpath = xpath.replace("{@param}", input.trim());
        WebElement element = driver.findElement(By.xpath(newXpath));
        element.click();
    }

    public void uploadById(By id, String link) {
        driver.findElement(id).sendKeys(System.getProperty("user.dir") + link);
    }

    public Map<String, String> getActualTableValue(String rowXpath, String columnXpath, String cellXpath) {
        List<WebElement> rows = driver.findElements(By.xpath(rowXpath));
        List<WebElement> columns = driver.findElements(By.xpath(columnXpath));

        Map<String, String> tableValues = new HashMap<>();

        for (int i = 1; i <= rows.size(); i++) {
            String keyCellXpath = cellXpath.replace("{@param1}", Integer.toString(i)).replace("{@param2}", "1");
            WebElement keyCell = driver.findElement(By.xpath(keyCellXpath));
            String key = keyCell.getText().trim();

            String value = "";

            for (int j = 2; j <= columns.size(); j++) { // Starting from 2 to skip the key column
                String newCellXpath = cellXpath.replace("{@param1}", Integer.toString(i));
                String finalCellXpath = newCellXpath.replace("{@param2}", Integer.toString(j));
                WebElement cell = driver.findElement(By.xpath(finalCellXpath));
                value = value + cell.getText().trim();
            }
            tableValues.put(key, value.trim());
        }
        return tableValues;
    }

    public Map<String, String> getExpectedTableValue(String expectedValue) {
        Map<String, String> expectedResultMap = new HashMap<>();

        // Split the string into lines
        String[] lines = expectedValue.split("\n");

        // Process each line to extract key and value
        for (String line : lines) {
            if (line.contains("=")) {
                String[] parts = line.split("=", 2); // Split into two parts at the first '='
                String key = parts[0].trim(); // Trim whitespace
                String value = parts[1].trim(); // Trim whitespace
                expectedResultMap.put(key, value); // Put into the map
            }
        }
        return expectedResultMap;
    }
}


