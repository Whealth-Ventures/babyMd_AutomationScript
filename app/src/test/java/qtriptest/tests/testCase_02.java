// package qtriptest.tests;
// import static org.testng.Assert.*;
// import java.net.MalformedURLException;
// import qtriptest.pages.*;

// import org.testng.annotations.*;
// import org.testng.annotations.Test;
// import org.testng.asserts.SoftAssert;
// import org.openqa.selenium.chrome.ChromeDriver;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.chrome.ChromeOptions;
// import qtriptest.DP;

// public class testCase_02{
//     public ChromeDriver driver;
//     @BeforeSuite(alwaysRun=true)
//     public void createDriver() throws MalformedURLException{
//         WebDriverManager.chromedriver().setup();
//         ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--window-size=1920,1200");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//     }
//   //  @Test(description="Search for city and clear filters", dataProvider = "data-Provider",dataProviderClass = DP.class){
//         HomePage home=new HomePage(driver);
//         home.gotoHomePage();
//         Thread.sleep(2000);
//         home.searchCity("Pune");
//         Boolean isNoCityFound=home.isNoCityFound();
//         Thread.sleep(2000);
//         SoftAssert softAssert = new SoftAssert();
//         softAssert.assertTrue(isNoCityFound,"No city found");

//         home.searchCity(cityName);
//         Thread.sleep(1000);
//         home.selectCity(cityName);
//         Thread.sleep(3000);
//         AdventurePage adventure=new AdventurePage(driver);
//         adventure.selectfilter();
//         Thread.sleep(2000);
//         adventure.selectCategory();
//         Thread.sleep(1000);
//         adventure.clearFilter();
//         Thread.sleep(1000);
//         adventure.clearCategory();
//         adventure.logout();
//         softAssert.assertAll();
//     }
//     @AfterSuite
//     public void quitDriver(){
//         driver.quit();
//     }
// }

