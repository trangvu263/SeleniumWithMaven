package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class PracticeFormPage extends Page {
    public PracticeFormPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void inputDate(String date) {
        String[] input = date.split(" ");

        WebElement dateField = dr.findElement(By.id("dateOfBirthInput"));
        js.executeScript("arguments[0].scrollIntoView(true);", dateField);
        dateField.click();

        WebElement year = dr.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText(input[2]);

        WebElement month = dr.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText(input[1]);

        String dayPickerXpath = "//div[contains(@class,'react-datepicker__day react-datepicker__day--" + 0 + input[0] + "') and (not(contains(@class,'outside-month')))]";
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
        String[] fieldNameValues = {"Email", "Mobile"};

        for(String value: fieldNameValues) {
            if(value.equals(fieldName)) {
                WebElement inputField1 = dr.findElement(By.xpath(xpath1));
                inputField1.sendKeys(input);
                return;
            }
        }
        WebElement inputField2 = dr.findElement(By.xpath(xpath2));
        inputField2.sendKeys(input);
    }

    public void selectGender(String radioValue) {
        String xpath = "//label[text()='" + radioValue + "']";
        WebElement radioButton = dr.findElement(By.xpath(xpath));
        radioButton.click();
    }

    public void selectCheckbox(String value) throws InterruptedException {
        String[] checkBoxItem = value.split(", ");
        for(String item: checkBoxItem) {
            String xpath = "//label[text()='" + item + "']";
            WebElement checkboxItem = dr.findElement(By.xpath(xpath));
            js.executeScript("arguments[0].scrollIntoView(true);", checkboxItem);
            boolean isSelected = checkboxItem.isSelected();
            if (!isSelected) {
                checkboxItem.click();
            }
        }
    }

    public void unSelectCheckbox(String value) {
        String[] checkBoxItem = value.split(", ");
        for(String item: checkBoxItem) {
            String xpath = "//label[text()='" + item + "']";
            WebElement checkboxItem = dr.findElement(By.xpath(xpath));
            boolean isSelected = checkboxItem.isSelected();
            if (isSelected) {
                checkboxItem.click();
            }
        }
    }

    public void uploadPicture(String link) {
        dr.findElement(By.id("uploadPicture")).sendKeys(link);
    }

    public void inputStateCity(String fieldName, String input) {
        String xpath = "//div[text()='" + fieldName + "']";
        WebElement inputField = dr.findElement(By.xpath(xpath));
        inputField.click();
        inputField.sendKeys(input);
        inputField.sendKeys(Keys.ENTER);
    }

    public void selectSubjects(String subjectName) {
        String[] subjects = subjectName.split(", ");
        WebElement subjectField = dr.findElement(By.xpath("//label[text()='Subjects']/following::input[1]"));
        subjectField.click();
        for(String input: subjects) {
            subjectField.sendKeys(input);
            subjectField.sendKeys(Keys.ENTER);
        }
    }
}
