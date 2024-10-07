package pages;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.TestBase.driver;

public class WebTablePage extends Page {

    public WebTablePage(WebDriver driverWeb) {
        super(driverWeb);
    }

    TestBase testBase = new TestBase();

    public By searchXpath = By.id("searchBox");
//    public String columnXpath = "//div[@role='columnheader']";
//    public String rowXpath = "//div[@role='rowgroup']";
//    public String cellXpath = "//div[@role='rowgroup'][{@param1}]/div/div[{@param2}]";
//
//    public Map<String, String> getEmployeeFormActualValue(String columnXpath, String rowXpath, String cellXpath) {
//        List<WebElement> columns = driver.findElements(By.xpath(columnXpath));
//        List<WebElement> rows = driver.findElements(By.xpath(rowXpath));
//
//        Map<String, String> tableValues = new HashMap<>();
//
//        for(int i = 1; i <= rows.size(); i++) {
//
//            for(int j = 1; j < columns.size(); j++) {
//                String newColumnXpath = columnXpath + "[j]";
//                WebElement column = driver.findElement(By.xpath(newColumnXpath));
//                String columnValue = column.getText();
//
//                String newCellXpath = cellXpath.replace("{@param1}", Integer.toString(i)).replace("{@param2}", Integer.toString(j));
//                WebElement cell = driver.findElement(By.xpath(newCellXpath));
//                String cellValue = cell.getText();
//
//                tableValues.put(columnValue, cellValue.trim());
//            }
//        }
//        return tableValues;
//    }
//}

    public boolean isFirstNameChecked(String searchText) {
        boolean isChecked = true;

        List<WebElement> rowElements = dr.findElements(By.xpath("//div[@role='rowgroup']"));
        int rowNum = rowElements.size();

        // count các cột blank
        for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
            int countColumnEmpty = 0;
            for (int i = 1; i <= 6; i++) {
                String columnXpath = "(//div[@role='row'])[" + (rowIndex+2) + "]/div[" + i + "]";
                WebElement columnElement = dr.findElement(By.xpath(columnXpath));
                if (columnElement.getText().equalsIgnoreCase("")) {
                    countColumnEmpty = countColumnEmpty + 1;
                }
            }

            if (countColumnEmpty != 6) {
                List<WebElement> firstNameElements = dr.findElements(By.xpath("//div[@role='rowgroup']/div/div[1]"));

                for (WebElement e : firstNameElements) {
                    String firstName = e.getText();
                    if (!firstName.contains(searchText)) {
                        System.out.println(firstName);
                        isChecked = false;
                        return isChecked;
                    }
                }
            }
        }
        return isChecked;
    }
}