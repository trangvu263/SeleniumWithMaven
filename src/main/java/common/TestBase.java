package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public TestBase(String configFile) {
        Configurations config = new Configurations(configFile);
    }

    public void openSingleBrowser(String url, String browser) {
        String downloadPath = System.getProperty("user.dir") + "\\testdata\\";

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", Map.of(
                    "download.default_directory", downloadPath,
                    "download.prompt_for_download", false,
                    "directory_upgrade", true));
            driver = new ChromeDriver(options);

//            options.addArguments("headless");
//            String projectPath = System.getProperty("user.dir");
//            System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver");
//            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("prefs", Map.of(
                    "download.default_directory", downloadPath,
                    "download.prompt_for_download", false,
                    "directory_upgrade", true));
            driver = new EdgeDriver(options);        }

        else if (browser.equalsIgnoreCase("safari")) {
            SafariOptions options = new SafariOptions();
//            options.setExperimentalOption("prefs", Map.of(
//                    "download.default_directory", downloadPath,
//                    "download.prompt_for_download", false,
//                    "directory_upgrade", true));
            driver = new SafariDriver(options);        }

        driver.get("url");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void closeWeb() {
        driver.quit();
    }

    public void inputText(By txtInput, String value) {
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

    public void scrollToElement(By byLocator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(byLocator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getTextByLocator(By byLocator) {
        String result = "";
        driver.findElement(byLocator).getText();
        return result;
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}


