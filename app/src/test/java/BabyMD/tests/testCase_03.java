// package BabyMD.tests;

// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.Test;

// import BabyMD.pages.Login;
// import BabyMD.pages.PatientDashBoard;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class testCase_03 {
//     static ChromeDriver driver;
//     String Doctorname="Doc Sanjay";
//          @BeforeSuite(alwaysRun=true)
//         public static void createDriver() {
//             System.out.println("Initialising the driver");
//             WebDriverManager.chromedriver().setup();
    
//             // Configure driver to start as headless
//             ChromeOptions options = new ChromeOptions();
//            // options.addArguments("--headless", "--window-size=1920,1200");
    
//              driver = new ChromeDriver(options);
//          driver.manage().window().maximize();
      
//     }
//     @Test
//     public void TestCase03() throws InterruptedException {
//         System.out.println("Test case 03 started");
//                  Login login= new Login(driver);
//                 login.navigateToLoginPage();
//                 Thread.sleep(3000);
//                 login.performLogin();
//         PatientDashBoard dashBoard=new PatientDashBoard(driver);
//         dashBoard.Patienturl();
//         dashBoard.navigateToLandingPage();
//         Thread.sleep(2000);
//         dashBoard.AssignDoctor(Doctorname);
//         Thread.sleep(2000);
//         dashBoard.AssignDoctor("Doc Sanjay");
//         Thread.sleep(2000);
//         dashBoard.Prescription();
//         Thread.sleep(2000);
//         dashBoard.clickMedicine();
//         Thread.sleep(2000);
//         dashBoard.CourseTime();
//         Thread.sleep(2000);
//         dashBoard.Selectfrequency();
//         Thread.sleep(2000);
//         dashBoard.selectregimen();
//         Thread.sleep(2000);
//         dashBoard.Save();
//     }
//     @AfterSuite
//     public static void quitDriver() {
//         System.out.println("quit()");

//         driver.quit();
     
//     }
// }
