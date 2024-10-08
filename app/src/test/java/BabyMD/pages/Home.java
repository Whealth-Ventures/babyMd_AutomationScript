package BabyMD.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Home {
    String url = "https://staging.babymd.in/patient";
    ChromeDriver driver;

    // Using @FindBy for locating elements
    @FindBy(xpath = "//div[text()='Add Patient']")
    WebElement addPatient;

    @FindBy(xpath = "//div[text()='Patient']")
    WebElement patient;

    @FindBy(className = "rs-picker-select-menu-item")
    List<WebElement> genderOptions;

    @FindBy(className = "rs-picker-select-menu-item")
    List<WebElement> relations;

    @FindBy(className = "option")
    List<WebElement> clinics;

    @FindBy(xpath = "//button[@class='rs-dropdown-toggle rs-dropdown-toggle-no-caret rs-btn rs-btn-default']")
    WebElement profile;

    @FindBy(xpath = "//*[@placeholder='Patient Name']")
    WebElement patientName;

    @FindBy(xpath = "//span[text()='Select Gender']")
    WebElement genderDropdown;

    @FindBy(xpath = "//*[@placeholder='YYYY-MM-DD']")
    WebElement dateOfBirth;

    @FindBy(xpath = "//*[@placeholder='10 Digit Mobile Number']")
    WebElement mobileNumber;

    @FindBy(xpath = "//span[text()='Select RelationShip']")
    WebElement relationshipDropdown;

    @FindBy(xpath = "//*[@placeholder='Select Clinic']")
    WebElement clinicDropdown;

    @FindBy(xpath = "//*[@placeholder='City']")
    WebElement cityInput;

    @FindBy(xpath = "//*[@placeholder='Pincode']")
    WebElement pincodeInput;

    @FindBy(xpath = "//*[@placeholder='parents name']")
    WebElement parentNameInput;

    @FindBy(xpath = "//*[@placeholder='weight']")
    WebElement weightInput;

    @FindBy(xpath = "//*[@placeholder='height']")
    WebElement heightInput;

    @FindBy(xpath = "//div[text()='Save Details']")
    WebElement saveButton;

    public Home(WebDriver driver) {
        this.driver = (ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void navigateToLandingPage() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
    }

    public void addPatient() throws InterruptedException {
        addPatient.click();
        Thread.sleep(3000);
    }

    public void signOut() throws InterruptedException {
        profile.click();
        Thread.sleep(3000);
        WebElement signOutButton = driver.findElement(By.xpath("//div[text()='Sign Out']"));
        signOutButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
    }

    public void clickPatient() {
        patient.click();
    }

    // Methods to interact with elements
    public void setPatientName(String name) throws InterruptedException {
        patientName.sendKeys(name);
        Thread.sleep(2000);
    }

    public void selectGender(String gender) {
        genderDropdown.click();
        for (WebElement genderOption : genderOptions) {
            if (genderOption.getText().equals(gender)) {
                genderOption.click();
                break;
            }
        }
    }

    public void setDateOfBirth(String dob) throws InterruptedException {
       dateOfBirth.click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall MuiPickersCalendarHeader-switchViewButton css-1wjkg3']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[text()='2020']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[text()='OK']")).click();
       Thread.sleep(2000);
    }
    

    public void setMobileNumber(String number) {
        mobileNumber.sendKeys(number);
    }

    public void selectRelationship(String relationship) {
        relationshipDropdown.click();
        for (WebElement relationOption : relations) {
            if (relationOption.getText().equals(relationship)) {
                relationOption.click();
                break;
            }
        }
    }

    public void selectClinic(String clinic) {
        clinicDropdown.click();
        for (WebElement clinicOption : clinics) {
            if (clinicOption.getText().equals(clinic)) {
                clinicOption.click();
                break;
            }
        }
    }

    public void setCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setPincode(String pincode) {
        pincodeInput.sendKeys(pincode);
    }

    public void setParentName(String parentName) {
        parentNameInput.sendKeys(parentName);
    }

    public void setWeight(String weight) {
        weightInput.sendKeys(weight);
    }

    public void setHeight(String height) {
        heightInput.sendKeys(height);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
