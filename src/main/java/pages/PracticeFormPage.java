package pages;

import common.TestBase;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.models.StudentRegister;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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

    public void inputData(StudentRegister studentRegister) {
        testBase.inputText(txtFirstName, studentRegister.firstName);
        testBase.inputText(txtLastName, studentRegister.lastName);
        testBase.inputText(txtEmail, studentRegister.email);
        testBase.selectRadioButtonByXpath(genderXpath, studentRegister.gender);
        testBase.inputText(txtMobile, studentRegister.mobilePhone);
        inputDate(studentRegister.dayOfBirth);
        testBase.inputMultiValuesToComboBox(cbSubjects, studentRegister.subjects);
        testBase.selectCheckboxByXpath(hobbiesXpath, studentRegister.hobbies);
        testBase.uploadById(uploadId, studentRegister.uploadPicture);
        testBase.inputText(currentAddressId, studentRegister.currentAddress);
        testBase.inputMultiValuesToComboBox(stateXpath, studentRegister.state);
        testBase.inputMultiValuesToComboBox(cityXpath, studentRegister.city);
    }

    public StudentRegister fillFormFromCSV(String csvFile) {
        StudentRegister student = new StudentRegister(); // Khởi tạo đối tượng ở đầu
        try (
                // read file CSV
                Reader in = new FileReader(csvFile);
                CSVParser csvParser = CSVFormat.DEFAULT.builder()
                        .setHeader("First Name", "Last Name", "Email", "Gender", "Mobile", "Date of Birth", "Subjects",
                                "Hobbies", "Picture", "Current Address", "State", "City")
                        .setSkipHeaderRecord(true) // Bỏ qua dòng tiêu đề nếu có trong file CSV
                        .setDelimiter(',') // Sử dụng dấu phẩy làm dấu phân cách
                        .build().parse(in)) {
            // Lặp qua từng dòng trong file CSV
            for (CSVRecord record : csvParser) {
                // Tạo đối tượng StudentRegister cho mỗi dòng dữ liệu
                // Gán các trường của file CSV cho từng thuộc tính của đối tượng
                student.firstName = record.get("First Name");
                student.lastName = record.get("Last Name");
                student.email = record.get("Email");
                student.gender = record.get("Gender");
                student.mobilePhone = record.get("Mobile");
                student.dayOfBirth = record.get("Date of Birth");
                student.subjects = record.get("Subjects");
                student.hobbies = record.get("Hobbies");
                student.uploadPicture = record.get("Picture");
                student.currentAddress = record.get("Current Address");
                student.state = record.get("State");
                student.city = record.get("City");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }


        //convert day to same format as table result dd mmm,yyyy
        public String convertDate(String date) {
            String[] dates = date.split(" ");
            String day = dates[0];
            int dayInt = Integer.valueOf(day);
            String newDate = "";
            if (dayInt < 10) {
                String newDay = "0" + String.valueOf(dayInt);
                newDate = newDay + " " + dates[1] + "," + dates[2];
            } else {
                newDate = dates[0] + " " + dates[1] + "," + dates[2];
            }
            return newDate;
        }
    }
