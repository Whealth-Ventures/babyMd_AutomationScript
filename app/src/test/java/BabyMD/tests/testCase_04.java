package BabyMD.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BabyMD.pages.Login;
import BabyMD.pages.PatientDashBoard;
import BabyMD.pages.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase_04 {
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
    @Test
    public void TestCase04() throws InterruptedException {
        System.out.println("Test case 03 started");
                 Login login= new Login(driver);
                login.navigateToLoginPage();
                Thread.sleep(3000);
         login.performLogin();
                Thread.sleep(3000);
                Settings goal=new Settings(driver);
        goal.navigateToLandingPage();
        Thread.sleep(3000);
        goal.addNewGoal();
        Thread.sleep(3000);
        goal.AddGoalDetails();
        Thread.sleep(3000);
        goal.frequencySelect();
        Thread.sleep(3000);
        goal.AddNotification();
        Thread.sleep(3000);
        goal.AddReminder();
        Thread.sleep(2000);
        goal.saveDetails();
       
        PatientDashBoard  patientDashBoard=new PatientDashBoard(driver);
        patientDashBoard.navigateToLandingPage();
        patientDashBoard.goalcreation();
        Thread.sleep(3000);
        goal.gotogoal();
        Thread.sleep(3000);
        goal.goalname();
        Thread.sleep(3000);
        goal.saveDetails();
   
    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}


