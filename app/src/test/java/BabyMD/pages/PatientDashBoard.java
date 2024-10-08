package BabyMD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PatientDashBoard {
    
ChromeDriver driver;
String url="https://staging.babymd.in/patient";
@FindBy(xpath="//div[contains(text(),'all patients (')]")
WebElement patientCountElement;
@FindBy(xpath = "//*[@placeholder='Assign Doctor/Clinic Manager']")
WebElement assignDoc;
@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div/div/div[2]/div/div[1]")
WebElement doctor;
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
}
