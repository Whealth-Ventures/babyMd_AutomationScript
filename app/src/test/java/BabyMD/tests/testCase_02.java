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
import BabyMD.pages.Home;

public class testCase_02 {
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
            test = report.startTest("Extent Test - TestCase 02");
            test.log(LogStatus.INFO, "Driver initialized successfully");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Driver initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(description = "Adding Patient details", dataProvider = "data-Provider", dataProviderClass = DP.class, priority = 2, groups = {"patient details"})
    public void TestCase02(String PatientName, String DOB, String Mobile, String Gender, String Relationship, String SecondaryMobile, String Clinic, String City, String Pincode, String Address, String State, String Parentsname, String Circumference, String Weight, String Height) throws InterruptedException {
        try {
            test.log(LogStatus.INFO, "Test case 02 started");

            Home home = new Home(driver);
            Thread.sleep(2000);

            home.navigateToLandingPage();
            test.log(LogStatus.INFO, "Navigated to landing page");

            home.addPatient();
            test.log(LogStatus.INFO, "Clicked to add patient");

            home.setPatientName(PatientName);
            test.log(LogStatus.PASS, "Patient name entered: " + PatientName);

            home.selectGender(Gender);
            test.log(LogStatus.PASS, "Gender selected: " + Gender);

            home.setDateOfBirth(DOB);
            test.log(LogStatus.PASS, "Date of birth entered: " + DOB);

            home.setMobileNumber(Mobile);
            test.log(LogStatus.PASS, "Mobile number entered: " + Mobile);

            home.selectRelationship(Relationship);
            test.log(LogStatus.PASS, "Relationship selected: " + Relationship);

            home.selectClinic(Clinic);
            test.log(LogStatus.PASS, "Clinic selected: " + Clinic);

            home.setCity(City);
            test.log(LogStatus.PASS, "City entered: " + City);

            home.setPincode(Pincode);
            test.log(LogStatus.PASS, "Pincode entered: " + Pincode);

            home.setParentName(Parentsname);
            test.log(LogStatus.PASS, "Parent name entered: " + Parentsname);

            home.setWeight(Weight);
            test.log(LogStatus.PASS, "Weight entered: " + Weight);

            home.setHeight(Height);
            test.log(LogStatus.PASS, "Height entered: " + Height);
Thread.sleep(3000);
            // Submit the form
            home.clickSaveButton();
            test.log(LogStatus.PASS, "Save button clicked - Patient details submitted");
            Thread.sleep(3000);
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TestCase 02 failed: " + e.getMessage());
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
