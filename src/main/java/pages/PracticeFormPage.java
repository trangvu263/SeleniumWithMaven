package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends Page {
    public PracticeFormPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void inputDate(String date) {
        String[] input = date.split(" ");

        dr.findElement(By.id("dateOfBirthInput")).click();

        WebElement year = dr.findElement(By.xpath("*[class='react-datepicker__year-select']"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("input[2]");

        WebElement month = dr.findElement(By.xpath("*[class='react-datepicker__month-select']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("input[1]");

        String dayPickerXpath = "//div[contains(@class,'react-datepicker__day react-datepicker__day--" + 0 + input[0] + ") and (not(contains(@class,'outside-month')))]";
        WebElement day = dr.findElement(By.xpath(dayPickerXpath));
        day.click();
    }

    public void inputName(String fieldName, String inputName) {
        String xpath = "//input[@placeholder='" + fieldName + "']";
        WebElement name = dr.findElement(By.xpath(xpath));
        name.sendKeys(inputName);
    }

    public void inputText(String fieldName, String input) {
        //Handle field text Email, Mobile, Subjects
        String xpath1 = "//label[text()='" + fieldName + "']/following::input[1]";
        //Handle field Current Address
        String xpath2 = "//label[text()='" + fieldName + "']/following::textarea";
        String[] fieldNameValues = {"Email", "Mobile", "Subjects"};


        for(String value: fieldNameValues) {
            if(value.equals(fieldName)) {
                WebElement inputField1 = dr.findElement(By.xpath(xpath1));
                inputField1.sendKeys(input);
            } else {
                WebElement inputField2 = dr.findElement(By.xpath(xpath2));
                inputField2.sendKeys(input);
            }
        }
    }

    public void selectGender(String radioValue) {
        String xpath = "//input[@value='" + radioValue + "']";
        WebElement radioButton = dr.findElement(By.xpath(xpath));
        radioButton.click();
    }

    public void selectCheckbox(String sports, String music) {
    }
}
