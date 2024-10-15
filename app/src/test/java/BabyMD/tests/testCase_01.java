package BabyMD.tests;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BabyMD.DP;
import BabyMD.DriverSingleton;
import BabyMD.pages.Login;

public class testCase_01{
    static WebDriver driver;
     @BeforeSuite(alwaysRun=true)
    public static void createDriver() throws IOException, InterruptedException {
        System.out.println("Initialising the driver");
              driver=(ChromeDriver) DriverSingleton.getDriverInstance("chrome");
    }
    public static void takeScreenshot(WebDriver driver, String screenshotType, String description) {
      try {
          File theDir = new File("/screenshots");
          if (!theDir.exists()) {
              theDir.mkdirs();
          }
          String timestamp = String.valueOf(java.time.LocalDateTime.now());
          String fileName = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, description);
          TakesScreenshot scrShot = ((TakesScreenshot) driver);
          File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
          File DestFile = new File("screenshots/" + fileName);
          FileUtils.copyFile(SrcFile, DestFile);
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
  @Test(description="Verify admin logged in", dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 1, groups = {"Login Flow"})
 
@Parameters({"Mobile","OTP"})
    public void TestCase01(String Mobile,String OTP) throws InterruptedException{
      takeScreenshot(driver,"StartTestCase","TestCase01");
        System.out.println("Test Case 1");
        Login login= new Login(driver);
        login.navigateToLoginPage();
        login.performLogin();
       
        takeScreenshot(driver,"EndTestCase","TestCase01");
        }
    
      @AfterSuite
    public static void quitDriver() {
        // createDriver();
        System.out.println("quit()");
      driver.close();
        driver.quit();
     
    }

}