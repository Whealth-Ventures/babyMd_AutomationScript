package BabyMD.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class Home{
    String url="https://staging.babymd.in/patient";
    ChromeDriver driver;
    
@FindBy(xpath="//div[text()='Add Patient']")
WebElement addPatient;

// @FindBy(xpath = "//*[@placeholder='Patient Name']")
// WebElement patientName;

// @FindBy(xpath = "//*[@placeholder='10 Digit Mobile Number']")
// WebElement patientPhone;

// @FindBy(xpath = "//*[@placeholder='Patient Address']")
// WebElement patientAddress;

// @FindBy(xpath = "//*[@placeholder='YYYY-MM-DD']")
// WebElement patientDob;

// @FindBy(xpath = "//span[text()='Select Gender']")
// WebElement patientGender;

// @FindBy(xpath = "//span[text()='Select Clinic']")
// WebElement patientClinic;

// @FindBy(xpath = "//span[text()='Select RelationShip']")
// WebElement patientRelationship;

// @FindBy(xpath = "//*[@placeholder='City']")
// WebElement city;

// @FindBy(xpath = "//*[@placeholder='Address Line 1']")
// WebElement AddressLine;

// @FindBy(xpath = "//*[@placeholder='State']")
// WebElement State;

// @FindBy(xpath = "//*[@placeholder='Pincode']")
// WebElement pinCode;

// @FindBy(xpath = "//*[@placeholder='parents name']")
// WebElement parentsName;

// @FindBy(xpath = "//div[text()='Save Details']")
// WebElement saveDetails;

     public Home(WebDriver driver) {
        this.driver=(ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public void navigateToLandingPage() throws InterruptedException {
        driver.get(url);
    Thread.sleep(3000);
    }
    public void addPatient() throws InterruptedException{
        addPatient.click();
        Thread.sleep(3000);
    }
     By patientName = By.xpath("//*[@placeholder='Patient Name']");

    By genderDropdown = By.id("gender-dropdown-id");
    By dateOfBirth = By.xpath("//*[@placeholder='YYYY-MM-DD']");

    By mobileNumber = By.xpath("//*[@placeholder='10 Digit Mobile Number']");

    By relationshipDropdown = By.xpath("//span[text()='Select RelationShip']");
    By clinicDropdown = By.xpath("//span[text()='Select Clinic']");

    By cityInput = By.xpath("//*[@placeholder='City']");
    By pincodeInput = By.xpath("//*[@placeholder='Pincode']");
    By parentNameInput = By.xpath("//*[@placeholder='parents name']");
    By weightInput = By.xpath("//*[@placeholder='weight']");
    By heightInput = By.xpath("//*[@placeholder='height']");
    By saveButton = By.xpath("//div[text()='Save Details']");

    // Constructor
   
    // Methods to interact with elements
    public void setPatientName(String name) throws InterruptedException {
        driver.findElement(patientName).sendKeys(name);
        Thread.sleep(2000);
    }

    public void selectGender(String gender) {
        Select genderSelect = new Select(driver.findElement(genderDropdown));
        genderSelect.selectByVisibleText(gender);
    }

    public void setDateOfBirth(String dob) {
        driver.findElement(dateOfBirth).sendKeys(dob);
    }

    public void setMobileNumber(String number) {
        driver.findElement(mobileNumber).sendKeys(number);
    }

    public void selectRelationship(String relationship) {
        Select relationshipSelect = new Select(driver.findElement(relationshipDropdown));
        relationshipSelect.selectByVisibleText(relationship);
    }

    public void selectClinic(String clinic) {
        Select clinicSelect = new Select(driver.findElement(clinicDropdown));
        clinicSelect.selectByVisibleText(clinic);
    }

    public void setCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void setPincode(String pincode) {
        driver.findElement(pincodeInput).sendKeys(pincode);
    }

    public void setParentName(String parentName) {
        driver.findElement(parentNameInput).sendKeys(parentName);
    }

    public void setWeight(String weight) {
        driver.findElement(weightInput).sendKeys(weight);
    }

   
    public void setHeight(String height) {
        driver.findElement(heightInput).sendKeys(height);
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

}
