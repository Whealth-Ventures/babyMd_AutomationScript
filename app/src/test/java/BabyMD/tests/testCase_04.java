package BabyMD.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BabyMD.DP;
import BabyMD.DriverSingleton;
import BabyMD.pages.Settings;

public class testCase_04 {
     static ChromeDriver driver;
 
         @BeforeSuite(alwaysRun=true)
        public static void createDriver() {
            System.out.println("Initialising the driver");
                  driver=(ChromeDriver) DriverSingleton.getDriverInstance("chrome");
      
    }
    @Test(description = "Adding Goal",dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 4, groups = {"Goal Creation"})
    public void TestCase04(String GoalName,String tagetValue,String Frequency,String Notification,String Reminder) throws InterruptedException {
        System.out.println("Test case 04 started");
        //          Login login= new Login(driver);
        //         login.navigateToLoginPage();
        //         Thread.sleep(3000);
        //  login.performLogin();
                Thread.sleep(3000);
                Settings goal=new Settings(driver);
        goal.navigateToLandingPage();
        Thread.sleep(3000);
        goal.addNewGoal();
        Thread.sleep(3000);
        goal.AddGoalDetails(GoalName,tagetValue);
        Thread.sleep(3000);
        goal.frequencySelect();
        Thread.sleep(3000);
        goal.AddNotification(Notification);
        Thread.sleep(3000);
        goal.AddReminder(Reminder);
        Thread.sleep(2000);
        goal.saveDetails();
       

    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}


