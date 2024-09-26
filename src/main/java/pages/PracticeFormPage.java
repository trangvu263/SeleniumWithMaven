package pages;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class PracticeFormPage extends Page {
    public PracticeFormPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    TestBase testBase = new TestBase();

    public By txtFirstName = By.id("firstName");
    public By txtLastName = By.id("lastName");
    public By txtEmail = By.id("userEmail");
    public By txtMobile = By.id("userNumber");
    public String genderXpath = "//label[text()='{@param}']";
    public By cbSubjects = By.xpath("//label[text()='Subjects']/following::input[1]");
    public String hobbiesXpath = "//label[text()='{@param}']";
    public By dateFieldXpath = By.id("dateOfBirthInput");
    public String yearDrXpath = "//*[@class='react-datepicker__year-select']";
    public String monthDrXpath = "//*[@class='react-datepicker__month-select']";
    public String dayXpath = "//div[contains(@class,'react-datepicker__day react-datepicker__day--{@param}') and (not(contains(@class,'outside-month')))]";
    public By uploadId = By.id("uploadPicture");
    public By currentAddressId = By.xpath("//label[text()='Current Address']/following::textarea");
    public By stateXpath = By.xpath("//div[text()='Select State']/following::input[1]");
    public By cityXpath = By.xpath("//div[text()='Select City']/following::input[1]");
    public String rowXpath = "//tbody/tr";
    public String columnXpath = "//thead/tr/th";
    public String cellXpath = "//tbody/tr[{@param1}]/td[{@param2}]";

    public void inputDate(String date) {
        WebElement dateField = dr.findElement(dateFieldXpath);
        js.executeScript("arguments[0].scrollIntoView(true);", dateField);
        testBase.clickById(dateFieldXpath);

        String[] input = date.split(" ");

        testBase.selectDrListByXpath(yearDrXpath, input[2]);
        testBase.selectDrListByXpath(monthDrXpath, input[1]);
        testBase.clickByXpath(dayXpath, 0 + input[0]);
    }

    public Map<String, String> getFormResult() {
        return testBase.getActualTableValue(rowXpath, columnXpath, cellXpath);
    }
}
