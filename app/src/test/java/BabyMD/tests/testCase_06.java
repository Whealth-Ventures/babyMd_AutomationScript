package BabyMD.tests;

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

public class testCase_06 {
    static ChromeDriver driver;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public static void createDriver() {
        try {
            System.out.println("Initialising the driver");
            driver = (ChromeDriver) DriverSingleton.getDriverInstance("chrome");
            ReportSingleton rs1 = ReportSingleton.getInstanceOfSingletonReportClass();
            report = rs1.getReport();
            test = report.startTest("Extent Test - TestCase 06");
            test.log(LogStatus.INFO, "Driver initialized successfully");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Driver initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(description = "Updating Patient dashboard", dataProvider = "data-Provider", dataProviderClass = DP.class, priority = 6, groups = {"Updation"})
    public void TestCase06(String goal, String NoteCategory, String Template, String Content, String Clinic, String Doctor, String Date, String Fee,String Booked, String Payment) throws InterruptedException {
        try {
            test.log(LogStatus.INFO, "Test case 06 started");

            PatientDashBoard patient = new PatientDashBoard(driver);
            patient.Patienturl();
            test.log(LogStatus.INFO, "Navigated to Patient URL");

            Thread.sleep(3000);
            patient.navigateToLandingPage();
            test.log(LogStatus.INFO, "Navigated to Landing Page");

            Thread.sleep(3000);
            patient.goalcreation();
            test.log(LogStatus.INFO, "Started goal creation");

            Thread.sleep(3000);
            patient.selectGoal(goal);
            test.log(LogStatus.PASS, "Goal selected: " + goal);

            Thread.sleep(3000);
            patient.addNotes(NoteCategory, Template, Content);
            test.log(LogStatus.PASS, "Notes added: Category - " + NoteCategory + ", Template - " + Template);

            Thread.sleep(3000);
            patient.addAppointmentForPatient();
            test.log(LogStatus.INFO, "Adding appointment for patient");

            Thread.sleep(2000);
            patient.updateAppointmentdetails(Clinic, Doctor, Date, Fee);
            test.log(LogStatus.PASS, "Appointment details updated: Clinic - " + Clinic + ", Doctor - " + Doctor);

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TestCase 06 failed: " + e.getMessage());
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
