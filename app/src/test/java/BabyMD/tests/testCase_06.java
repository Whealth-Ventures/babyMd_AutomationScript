package BabyMD.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BabyMD.DP;
import BabyMD.DriverSingleton;
import BabyMD.pages.PatientDashBoard;

public class testCase_06{
     static ChromeDriver driver;
 
         @BeforeSuite(alwaysRun=true)
        public static void createDriver() {
            System.out.println("Initialising the driver");
      
        driver=(ChromeDriver) DriverSingleton.getDriverInstance("chrome");
      
    }
    @Test(description = "Adding Notes",dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 6, groups = {"Notes Creation"})
    public void TestCase06(String goal,String NoteCategory,String Template,String Content,String Clinic,String Doctor,String Date,String Fee)throws InterruptedException {
        System.out.println("Test case 06 started");

                Thread.sleep(3000);
                PatientDashBoard patient=new PatientDashBoard(driver);
                patient.Patienturl();
                Thread.sleep(3000);
                patient.navigateToLandingPage();
                Thread.sleep(3000);
                patient.goalcreation();
                Thread.sleep(3000);
                patient.selectGoal(goal);
                Thread.sleep(3000);
                patient.addNotes(NoteCategory,Template,Content);
                Thread.sleep(3000);

patient.addAppointmentForPatient();
Thread.sleep(2000);
patient.updateAppointmentdetails(Clinic, Doctor,Date, Fee);
             
      
   
    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}

