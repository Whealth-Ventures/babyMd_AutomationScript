package BabyMD.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BabyMD.DP;
import BabyMD.DriverSingleton;
import BabyMD.pages.Settings;

public class testCase_05 {
     static ChromeDriver driver;
 
         @BeforeSuite(alwaysRun=true)
        public static void createDriver() {
            System.out.println("Initialising the driver");
                  driver=(ChromeDriver) DriverSingleton.getDriverInstance("chrome");
      
    }
    @Test(description = "Adding Notes",dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 5, groups = {"Notes Creation"})
    public void TestCase05(String NoteName,String Category,String Title)throws InterruptedException {
        System.out.println("Test case 05 started");
        //          Login login= new Login(driver);
        //         login.navigateToLoginPage();
        //         Thread.sleep(3000);
        //  login.performLogin();
                Thread.sleep(3000);
                Settings goal=new Settings(driver);
        goal.navigateToLandingPage();
       
       Thread.sleep(3000);
       goal.addNotecategory(NoteName);
       Thread.sleep(3000);
      
    //    goal.addNotetemplate();
      
   
    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}

