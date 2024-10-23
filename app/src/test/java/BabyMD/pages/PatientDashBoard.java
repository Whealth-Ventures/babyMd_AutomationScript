package BabyMD.pages;

import java.util.List;

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


@FindBy(xpath="//span[text()='Search Goal']")
WebElement searchGoal;

@FindBy(xpath ="//div[text()='Notes']")
WebElement notes;

@FindBy(xpath="//span[text()='Select Category']")
WebElement selectCategory;
@FindBy(xpath="//span[text()='Select']")
WebElement selectTemplate;
@FindBy(xpath="//*[@class='form-control coreInput textArea']")
WebElement content;

@FindBy(xpath="//div[text()='Submit']")
WebElement submit;

@FindBy(xpath="//div[text()='Appointments']")
WebElement appointments;
@FindBy(xpath="//button[text()=' Add Appointment']")
WebElement addAppointment;

@FindBy(xpath="//span[text()='Clinic']")
WebElement clinic;

@FindBy(xpath="//span[text()='Doctor']")
WebElement doctorName;

@FindBy(xpath="//*[@placeholder='yyyy-MM-dd']")
WebElement date1;

@FindBy(xpath ="//*[@id='root']/div[2]/div[2]/div/div[9]/div/div[1]")
WebElement timeslot;


@FindBy(xpath="//*[@placeholder='Appointment Fee']")
WebElement appointmentFee;

@FindBy(xpath="//*[@class='reusableBtnActive  reusableBtn  w-100']")
WebElement createAppointment;

@FindBy(xpath="//span[text()='close']")
WebElement cancel;

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div")
WebElement editAppointment;

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[11]/div[1]/div")
WebElement UpdateAppointment;


@FindBy(xpath = "//div[text()='Record Payment']")
WebElement recordPayment;


@FindBy(xpath ="//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[5]/div[2]/div[2]/div[1]/div")
WebElement RecordPayment;
@FindBy(xpath="//span[text()='Select']")
WebElement selectPaymentMethod;

@FindBy(xpath = "//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[2]")
WebElement appointmentDetails;

@FindBy(xpath = "//div[text()='Cancel Appointment']")
WebElement cancelAppointment;

@FindBy(xpath="//label[text()='canceled']")
WebElement cancelledApElement;


@FindBy(xpath="//span[text()='booked']")
WebElement editBookButton;

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[11]/div[2]/div")
WebElement createAndpay;

 public PatientDashBoard(WebDriver driver) {
        this.driver = (ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
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
public void selectGoal(String goaName) throws InterruptedException{
    searchGoal.click();
    Thread.sleep(3000);
    List<WebElement> goals=driver.findElements(By.className("rs-picker-select-menu-item"));
    for(WebElement goal:goals){
        if(goal.getText().equals(goaName)){
            goal.click();
            break;
            }
            }
            Thread.sleep(2000);
            saveDetails.click();
            }

public void addNotes(String notecategory,String Template,String contents) throws InterruptedException{
    notes.click();
    Thread.sleep(2000);
    selectCategory.click();
    List<WebElement>categories=driver.findElements(By.className("rs-picker-select-menu-item"));
    for(WebElement category:categories){
        if(category.getText().equals(notecategory)){
            category.click();
            break;
            }
        }
        Thread.sleep(3000);
        selectTemplate.click();
        List<WebElement>templates=driver.findElements(By.className("rs-picker-select-menu-item"));
        for (WebElement template : templates) {
            if (template.getText().equals(Template)) {
                template.click();
                break;
        }
    }
        Thread.sleep(3000);
        content.sendKeys(contents);
        Thread.sleep(3000);
        submit.click();
}


public void addAppointmentForPatient() throws InterruptedException{
    appointments.click();
    Thread.sleep(3000);
    addAppointment.click();
    Thread.sleep(2000);
    
}

public void updateAppointmentdetails(String Clinic,String doctor,String date,String appointmentfee) throws InterruptedException{
clinic.click();
Thread.sleep(2000);
List<WebElement> clinics=driver.findElements(By.className("rs-picker-select-menu-item"));
for (WebElement clinicname:clinics) {
    if(clinicname.getText().equals(Clinic))
    {
        clinicname.click();
        break;
    }
    
}
Thread.sleep(3000);
doctorName.click();
List<WebElement> doctors=driver.findElements(By.className("rs-picker-select-menu-item"));
for (WebElement doctorname:doctors) {
    if(doctorname.getText().equals(doctor))
    {
        doctorname.click();
        break;

}
}
Thread.sleep(2000);
date1.sendKeys("2024-10-24");
Thread.sleep(2000);
timeslot.click();
Thread.sleep(2000);
appointmentFee.sendKeys(appointmentfee);
Thread.sleep(2000);
createAppointment.click();
Thread.sleep(5000);
}

//update appintment 
public void updateStatus() throws InterruptedException{
String text=appointmentDetails.getText();
System.out.println(text);
cancel.click();
Thread.sleep(2000);
cancelAppointment.click();
Thread.sleep(2000);

}

public boolean  verifyCancellation(){
    return cancelledApElement.isDisplayed();
    }

    //update payment
//     public void updatePayment(String Booked,String Payment) throws InterruptedException{
//  editBookButton.click();
//         Thread.sleep(2000);
//         List<WebElement> attendances=driver.findElements(By.className("rs-dropdown-item"));
//         for (WebElement paymentmethod:attendances) {
// if(paymentmethod.getText().equals(Booked)){
//     paymentmethod.click();
//     break;
// }
//      Thread.sleep(2000);   
   
// }
// List<WebElement> attendanceTypes=driver.findElements(By.className("rs-picker-select-menu-item"));
// for (WebElement paymentmethod:attendanceTypes) {
// if(paymentmethod.getText().equals("Arrived")){
// paymentmethod.click();
// break;
// }
// Thread.sleep(2000);   

// }

//     //payment type
//     selectPaymentMethod.click();
//     Thread.sleep(2000);
//     List<WebElement> payments=driver.findElements(By.className("rs-picker-select-menu-item"));
//     for (WebElement paymenttype:payments) {
//         if(paymenttype.getText().equals(Payment)){
//             paymenttype.click();
//             break;
//         }
// Thread.sleep(2000);
// }
// recordPayment.click();
// Thread.sleep(2000);
// }
//update appointment with payment

public void createAppointmentwithPayment(String Clinic, String doctor,String appointmentfee,String Booked,String Payment) throws InterruptedException{
    clinic.click();
Thread.sleep(2000);
List<WebElement> clinics=driver.findElements(By.className("rs-picker-select-menu-item"));
for (WebElement clinicname:clinics) {
    if(clinicname.getText().equals(Clinic))
    {
        clinicname.click();
        break;
    }
    
}
Thread.sleep(3000);
doctorName.click();
List<WebElement> doctors=driver.findElements(By.className("rs-picker-select-menu-item"));
for (WebElement doctorname:doctors) {
    if(doctorname.getText().equals(doctor))
    {
        doctorname.click();
        break;

}
}
Thread.sleep(2000);
date1.sendKeys("2024-10-24");
Thread.sleep(2000);
timeslot.click();
Thread.sleep(2000);
appointmentFee.sendKeys(appointmentfee);
Thread.sleep(2000);
createAndpay.click();
Thread.sleep(5000);
selectPaymentMethod.click();
List<WebElement> attendanceTypes=driver.findElements(By.className("rs-picker-select-menu-item"));
for (WebElement paymentmethod:attendanceTypes) {
if(paymentmethod.getText().equals(Booked)){
paymentmethod.click();
break;
}
Thread.sleep(2000);   

}

    //payment type
    selectPaymentMethod.click();
    Thread.sleep(2000);
    List<WebElement> payments=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement paymenttype:payments) {
        if(paymenttype.getText().equals(Payment)){
            paymenttype.click();
            break;
        }
Thread.sleep(2000);
}
recordPayment.click();
Thread.sleep(2000);
}
public boolean verfiyArrived(){
    return driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div[3]")).getText().contains("Arrived");
}
}
