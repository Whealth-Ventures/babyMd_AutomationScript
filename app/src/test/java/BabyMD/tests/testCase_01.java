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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BabyMD.DP;
import BabyMD.DriverSingleton;
import BabyMD.ReportSingleton;
import BabyMD.pages.Login;

public class testCase_01 {
    static WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeSuite(alwaysRun=true)
    public static void createDriver() throws IOException, InterruptedException {
        System.out.println("Initialising the driver");
        driver = (ChromeDriver) DriverSingleton.getDriverInstance("chrome");
        ReportSingleton rs1 = ReportSingleton.getInstanceOfSingletonReportClass();
        report = rs1.getReport();
        test = report.startTest("Extent Test");
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
            test.log(LogStatus.FAIL, "Screenshot capture failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(description="Verify admin logged in", dataProvider = "data-Provider", dataProviderClass = DP.class, priority = 1, groups = {"Login Flow"})
    @Parameters({"Mobile", "OTP"})
    public void TestCase01(String Mobile, String OTP) throws InterruptedException {
        try {
            takeScreenshot(driver, "StartTestCase", "TestCase01");
            test.log(LogStatus.INFO, "Start TestCase1");

            System.out.println("Test Case 1");
            Login login = new Login(driver);

            login.navigateToLoginPage();
            test.log(LogStatus.INFO, "Navigated to login page");

            login.performLogin();
            test.log(LogStatus.PASS, "Login performed successfully");

            takeScreenshot(driver, "EndTestCase", "TestCase01");
            test.log(LogStatus.PASS, "TestCase 1 passed");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "TestCase 1 failed: " + e.getMessage());
            takeScreenshot(driver, "Error", "TestCase01_Failure");
            e.printStackTrace();
        }
    }

    @AfterSuite
    public static void quitDriver() {
        try {
            System.out.println("quit()");
            if (driver != null) {
                driver.close();
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
