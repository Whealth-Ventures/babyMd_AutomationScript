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
import BabyMD.pages.Settings;

public class testCase_05 {
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
            test = report.startTest("Extent Test - TestCase 05");
            test.log(LogStatus.INFO, "Driver initialized successfully");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Driver initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(description = "Adding Notes", dataProvider = "data-Provider", dataProviderClass = DP.class, priority = 5, groups = {"Notes Creation"})
    public void TestCase05(String NoteName, String Category, String Title) throws InterruptedException {
        try {
            test.log(LogStatus.INFO, "Test case 05 started");

            Settings goal = new Settings(driver);

            goal.navigateToLandingPage();
            test.log(LogStatus.INFO, "Navigated to Landing Page");

            Thread.sleep(3000);

            goal.addNotecategory(NoteName);
            test.log(LogStatus.PASS, "Note category added: " + NoteName);

            Thread.sleep(3000);
            // goal.addNotetemplate();
            // test.log(LogStatus.PASS, "Note template added: " + Title);

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TestCase 05 failed: " + e.getMessage());
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
