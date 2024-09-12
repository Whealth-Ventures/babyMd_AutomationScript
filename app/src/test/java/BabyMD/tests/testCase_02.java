package BabyMD.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BabyMD.DP;
import BabyMD.pages.Home;
import BabyMD.pages.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase_02 {
    static ChromeDriver driver;
     @BeforeSuite(alwaysRun=true)
    public static void createDriver() {
        System.out.println("Initialising the driver");
        WebDriverManager.chromedriver().setup();

        // Configure driver to start as headless
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless", "--window-size=1920,1200");

         driver = new ChromeDriver(options);
         driver.manage().window().maximize();
      
    }

    @Test(description = "Adding Patient details",dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 2, groups = {"patient details"})
    public void TestCase02(
        String PatientName, 
        String DOB, 
        String Mobile, 
        String Gender, 
        String Relationship,
        String Clinic, 
        String City, 
        String Pincode, 
        String Address, 
        String State, 
        String Parentsname, 
        String Circumference, 
        String Weight, 
        String Height
    ) throws InterruptedException {
        System.out.println("Test case 02 started");
        Login login=new Login(driver);
login.navigateToLoginPage();
login.performLogin();
        Home updatePatientPage=new Home(driver);
        updatePatientPage.navigateToLandingPage();
        updatePatientPage.addPatient();
       
          updatePatientPage.setPatientName(PatientName);
          Thread.sleep(2000);
          updatePatientPage.selectGender(Gender);
          Thread.sleep(2000);
          updatePatientPage.setDateOfBirth(DOB);
          Thread.sleep(2000);
          updatePatientPage.setMobileNumber(Mobile);
          Thread.sleep(2000);
          updatePatientPage.selectRelationship(Relationship);
          Thread.sleep(2000);
          updatePatientPage.selectClinic(Clinic);
          Thread.sleep(2000);
          updatePatientPage.setCity(City);
          Thread.sleep(2000);
          updatePatientPage.setPincode(Pincode);
          Thread.sleep(2000);
          updatePatientPage.setParentName(Parentsname);
          Thread.sleep(2000);
          updatePatientPage.setWeight(Weight);
          Thread.sleep(2000);
          updatePatientPage.setHeight(Height);
          Thread.sleep(2000);
  
          // Submit the form
          updatePatientPage.clickSaveButton();
        System.out.println("Test case 02 completed");

    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}


