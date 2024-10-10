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
        String PatientName, String DOB, String Mobile,String Gender,String Relationship,String SecondaryMobile,String Clinic,String City,String Pincode, String Address,String State,String Parentsname,String Circumference, String Weight, String Height
    ) throws InterruptedException {
        System.out.println("Test case 02 started");
         Login login= new Login(driver);
        login.navigateToLoginPage();
        login.performLogin();
        Home home = new Home(driver);
    // home.ClickPatient();
        Thread.sleep(2000);
       home.navigateToLandingPage();
        
        home.addPatient();
       
          home.setPatientName(PatientName);
          Thread.sleep(2000);
       home.selectGender(Gender);
          Thread.sleep(2000);
         home.setDateOfBirth(DOB);
          Thread.sleep(2000);
        
       home.setMobileNumber(Mobile);
          Thread.sleep(2000);
         home.selectRelationship(Relationship);
          Thread.sleep(2000);
         home.selectClinic(Clinic);
          Thread.sleep(2000);
          home.setCity(City);
          Thread.sleep(2000);
         home.setPincode(Pincode);
          Thread.sleep(2000);
         home.setParentName(Parentsname);
          Thread.sleep(2000);
      home.setWeight(Weight);
          Thread.sleep(2000);
       home.setHeight(Height);
          Thread.sleep(2000);
  
          // Submit the form
      home.clickSaveButton();
        System.out.println("Test case 02 completed");

    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}


