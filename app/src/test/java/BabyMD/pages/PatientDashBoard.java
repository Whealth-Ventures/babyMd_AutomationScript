package BabyMD.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class PatientDashBoard {
    
ChromeDriver driver;
String url="https://staging.babymd.in/patient";
@FindBy(xpath="//div[contains(text(),'all patients (')]")
WebElement patientCountElement;
@FindBy(xpath = "//*[@placeholder='Assign Doctor/Clinic Manager']")
WebElement assignDoc;
@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div[2]/div/div[1]")
WebElement doctor;
@FindBy(xpath="//div[text()='Prescription']")
WebElement prescription;
@FindBy(xpath="//button[text()=' New Prescription']")
WebElement newPrescription;
@FindBy(xpath="//span[text()='Select Doctor']")
WebElement selectDoctor;

@FindBy(xpath="//span[text()='Doc Sanjay']")
WebElement selectDoctorName;

@FindBy(xpath="//*[@placeholder='Diagnosis']")
WebElement diagnosis;

@FindBy(xpath="//span[text()='Search Medicine Name']")
WebElement MedicineName;
@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div/select")
WebElement frequency;
@FindBy(xpath="//label[text()='Morning']")
WebElement regimen;
@FindBy(xpath = "//*[@placeholder='Course Duration ']")
WebElement CourseDuration;

@FindBy(xpath = "//*[@placeholder='Advice']")
WebElement advice;
@FindBy(xpath="//div[text()='Save Details']")
WebElement saveDetails;

@FindBy(xpath="//div[text()='Goal']")
WebElement goal;

@FindBy(xpath="//button[text()=' Add Goal']")
WebElement addGoal;

 public PatientDashBoard(WebDriver driver) {
        this.driver = (ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public PatientDashBoard() {
    }
public void Patienturl() throws InterruptedException{
    driver.get(url);
    Thread.sleep(3000);

}

public void navigateToLandingPage() throws InterruptedException{

    String patientCountText = patientCountElement.getText();
    String extractedPatientID = patientCountText.replaceAll("\\D+", ""); 
    int patientIDInt = Integer.parseInt(extractedPatientID);
      String  adjustedPatientID = String.valueOf(patientIDInt);
              
    String patientDashboardUrl = "https://staging.babymd.in/patient/" + adjustedPatientID + "/dashboard";
  
    driver.get(patientDashboardUrl);
    Thread.sleep(3000);

}
public void AssignDoctor(String Doctorname) throws InterruptedException {
    assignDoc.sendKeys(Doctorname);
    Thread.sleep(2000);
    doctor.click();
}
public void Prescription() throws InterruptedException{
    prescription.click();
    Thread.sleep(3000);
    newPrescription.click();
}
public void clickMedicine(String Diagonis) throws InterruptedException{
    selectDoctor.click();
    Thread.sleep(3000);
selectDoctorName.click();
Thread.sleep(2000);
diagnosis.sendKeys(Diagonis);
Thread.sleep(2000);
MedicineName.click();
driver.findElement(By.xpath("//span[text()='Cream/Ointment Himalaya Neem']")).click();
}
public void CourseTime(String CourseDur) throws InterruptedException{
    CourseDuration.sendKeys(CourseDur);
    Thread.sleep(3000);
}
public void Selectfrequency(String Frequency) throws InterruptedException{
    Select select =new Select(frequency);
    select.selectByVisibleText(Frequency);
}
public void selectregimen(String Advice){
    regimen.click();
    advice.sendKeys(Advice);
}
public void Save() throws InterruptedException{
    saveDetails.click();
}
public void goalcreation() throws InterruptedException{
    goal.click();
    Thread.sleep(3000);
    addGoal.click();
}
}