package BabyMD.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BabyMD.DP;
import BabyMD.DriverSingleton;
import BabyMD.ReportSingleton;
import BabyMD.pages.PatientDashBoard;

public class testCase_03 {
    static ChromeDriver driver;
    static ExtentReports report;
    static ExtentTest test;
    String Doctorname = "Doc Sanjay";

    @BeforeSuite(alwaysRun = true)
    public static void createDriver() {
        try {
            System.out.println("Initialising the driver");
            driver = (ChromeDriver) DriverSingleton.getDriverInstance("chrome");
            ReportSingleton rs1 = ReportSingleton.getInstanceOfSingletonReportClass();
            report = rs1.getReport();
            test = report.startTest("Extent Test - TestCase 03");
            test.log(LogStatus.INFO, "Driver initialized successfully");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Driver initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(description = "Adding Prescription", dataProvider = "data-Provider", dataProviderClass = DP.class, priority = 3, groups = {"Prescription"})
    public void TestCase03(String DoctorName, String Diagonis, String MedicineName, String CourseDuration, String Frequency, String Regimen, String Advice) throws InterruptedException {
        try {
            test.log(LogStatus.INFO, "Test case 03 started");

            PatientDashBoard dashBoard = new PatientDashBoard(driver);
            dashBoard.Patienturl();
            test.log(LogStatus.INFO, "Navigated to Patient URL");

            dashBoard.navigateToLandingPage();
            test.log(LogStatus.INFO, "Navigated to Landing Page");

            dashBoard.AssignDoctor(Doctorname);
            test.log(LogStatus.INFO, "Assigned default Doctor: " + Doctorname);
            Thread.sleep(3000);
            dashBoard.AssignDoctor(DoctorName);
            test.log(LogStatus.PASS, "Assigned Doctor: " + DoctorName);
            Thread.sleep(3000);
            dashBoard.Prescription();
            test.log(LogStatus.INFO, "Opened Prescription form");
            Thread.sleep(3000);
            dashBoard.clickMedicine(Diagonis);
            test.log(LogStatus.PASS, "Entered Diagnosis: " + Diagonis);
            Thread.sleep(3000);
            dashBoard.CourseTime(CourseDuration);
            test.log(LogStatus.PASS, "Course Duration set: " + CourseDuration);
            Thread.sleep(3000);
            dashBoard.Selectfrequency(Frequency);
            test.log(LogStatus.PASS, "Frequency set: " + Frequency);
            Thread.sleep(3000);
            dashBoard.selectregimen(Advice);
            test.log(LogStatus.PASS, "Regimen set: " + Advice);
            Thread.sleep(3000);
            dashBoard.Save();
            test.log(LogStatus.PASS, "Prescription saved successfully");
            Thread.sleep(3000);
            // Click and publish prescription
            driver.findElement(By.xpath("//div[text()='Prescription']")).click();
            test.log(LogStatus.INFO, "Navigated to Prescription tab");

            driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div/div[1]/div[2]/div[4]/div/span")).click();
            test.log(LogStatus.INFO, "Selected the prescription for publishing");

            driver.findElement(By.xpath("//button[text()='Publish']")).click();
            test.log(LogStatus.INFO, "Clicked Publish button");

            Alert alert = driver.switchTo().alert();
            alert.accept();
            test.log(LogStatus.PASS, "Accepted publish alert");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TestCase 03 failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterSuite
    public static void quitDriver() {
        try {
            System.out.println("quit()");
            if (driver != null) {
                driver.quit();
                test.log(LogStatus.PASS, "Driver quit successfully");
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Driver quit failed: " + e.getMessage());
        } finally {
            if (report != null) {
                report.flush();
                test.log(LogStatus.INFO, "Report flushed");
            }
        }
    }
}
