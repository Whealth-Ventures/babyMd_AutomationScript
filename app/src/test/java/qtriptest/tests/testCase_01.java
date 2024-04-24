package qtriptest.tests;
import static org.testng.Assert.*;
import java.net.MalformedURLException;
import qtriptest.pages.*;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import qtriptest.DP;

public class testCase_01 {
  public static ChromeDriver driver;
  static String lastgeneratedUsername="";
    public static void createDriver() {
        System.out.println("Initialising the driver");
        WebDriverManager.chromedriver().setup();

        // Configure driver to start as headless
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "--window-size=1920,1200");

         driver = new ChromeDriver(options);
         driver.manage().window().maximize();
        
      
    }
   @Test(description="Verify user logged in", dataProvider = "data-Provider",dataProviderClass = DP.class, priority = 1, groups = {"Login Flow"})
 
    @Parameters({ "TC1_userMail", "TC1_userPassword" })
    public void TestCase01(@Optional("testUser@gmail.com") String TC1_userMail, @Optional("abc@12345") String TC1_userPassword) throws InterruptedException {
      createDriver();
        HomePage home = new HomePage(driver);
        home.gotoHomePage();
        home.clickRegister();
        SoftAssert sa = new SoftAssert();
        RegisterPage registration = new RegisterPage(driver);
       registration.registerUser(TC1_userMail, TC1_userPassword, true);
        lastgeneratedUsername=registration.lastGeneratedUsername;
        LoginPage login = new LoginPage(driver);
        login.navigateToLoginPage();
        assertTrue(login.performLogin(lastgeneratedUsername, TC1_userPassword),"Failed to login");
        assertTrue(home.isUserLoggedIn(),"Failure to Login using registered user");
        home.logOutUser();
        assertFalse(home.isUserLoggedIn(),"Failure in verification of user logout");
      //  // test.log(LogStatus.INFO, test.addScreenCapture(SeleniumWrapper.takeScreenshot(driver, "PASS", "Login")));
        home.gotoHomePage();
    }

    @AfterSuite
    public static void quitDriver() {
        createDriver();
        System.out.println("quit()");
    
        driver.quit();
     
    }

}
