package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends Page {
    public PracticeFormPage(WebDriver driverWeb) {
        super(driverWeb);
    }

    public void inputData() {

        inputDate();
    }
    public void inputDate() {
        dr.findElement(By.id("dateOfBirthInput")).click();
        WebElement drYear = dr.findElement(By.xpath("*[class='react-datepicker__month-select']"));
        Select selectYear = new Select(drYear);
        selectYear.deselectByVisibleText("1995");

    }
}
