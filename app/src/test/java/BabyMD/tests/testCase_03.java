package BabyMD.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BabyMD.DP;
import BabyMD.pages.Login;
import BabyMD.pages.PatientDashBoard;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase_03 {
    static ChromeDriver driver;
    String Doctorname="Doc Sanjay";
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
    @Test(description = "Adding Prescription",dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 3, groups = {"Prescription"})
    public void TestCase03(String DoctorName,String Diagonis,String MedicineName,String CourseDuration,String Frequency,String Regimen,String Advice) throws InterruptedException {
        System.out.println("Test case 03 started");
                 Login login= new Login(driver);
                login.navigateToLoginPage();
                Thread.sleep(3000);
                login.performLogin();
        PatientDashBoard dashBoard=new PatientDashBoard(driver);
        dashBoard.Patienturl();
        dashBoard.navigateToLandingPage();
        Thread.sleep(2000);
        dashBoard.AssignDoctor(Doctorname);
        Thread.sleep(2000);
        dashBoard.AssignDoctor(DoctorName);
        Thread.sleep(2000);
        dashBoard.Prescription();
        Thread.sleep(2000);
        dashBoard.clickMedicine(Diagonis);
        Thread.sleep(2000);
        dashBoard.CourseTime(CourseDuration);
        Thread.sleep(2000);
        dashBoard.Selectfrequency(Frequency);
        Thread.sleep(2000);
        dashBoard.selectregimen(Advice);
        Thread.sleep(2000);
        dashBoard.Save();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Prescription']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div/div[1]/div[2]/div[4]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Publish']")).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
        Thread.sleep(000);
        // driver.findElement(By.xpath("//*[@id='sidebar']//print-preview-button-strip//div/cr-button[2]")).click();
        // Thread.sleep(3000);

    }
    @AfterSuite
    public static void quitDriver() {
        System.out.println("quit()");

        driver.quit();
     
    }
}
