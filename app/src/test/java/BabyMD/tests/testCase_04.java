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

public class testCase_04 {
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
            test = report.startTest("Extent Test - TestCase 04");
            test.log(LogStatus.INFO, "Driver initialized successfully");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Driver initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(description = "Adding Goal", dataProvider = "data-Provider", dataProviderClass = DP.class, priority = 4, groups = {"Goal Creation"})
    public void TestCase04(String GoalName, String targetValue, String Frequency, String Notification, String Reminder) throws InterruptedException {
        try {
            test.log(LogStatus.INFO, "Test case 04 started");

            Settings goal = new Settings(driver);

            goal.navigateToLandingPage();
            test.log(LogStatus.INFO, "Navigated to Landing Page");

            Thread.sleep(3000);
            goal.addNewGoal();
            test.log(LogStatus.INFO, "Clicked on 'Add New Goal'");

            Thread.sleep(3000);
            goal.AddGoalDetails(GoalName, targetValue);
            test.log(LogStatus.PASS, "Goal details added: " + GoalName + ", Target Value: " + targetValue);

            Thread.sleep(3000);
            goal.frequencySelect();
            test.log(LogStatus.PASS, "Frequency selected");

            Thread.sleep(3000);
            goal.AddNotification(Notification);
            test.log(LogStatus.PASS, "Notification set: " + Notification);

            Thread.sleep(3000);
            goal.AddReminder(Reminder);
            test.log(LogStatus.PASS, "Reminder set: " + Reminder);

            Thread.sleep(2000);
            goal.saveDetails();
            test.log(LogStatus.PASS, "Goal details saved successfully");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TestCase 04 failed: " + e.getMessage());
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
