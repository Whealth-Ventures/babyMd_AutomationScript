package BabyMD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login{
String url="https://staging.babymd.in/";
String Mobile="9643243200";
String OTP="596921";
ChromeDriver driver;


@FindBy(xpath="//*[@placeholder='Registered Mobile Number']")
WebElement mobileNo;

@FindBy(xpath="//div[text()='Send OTP']")
WebElement sendOTP;

@FindBy(xpath = "//*[@class='otp__digit field__1']")
WebElement otp1;

@FindBy(xpath = "//*[@class='otp__digit field__2']")
WebElement otp2;

@FindBy(xpath = "//*[@class='otp__digit field__3']")
WebElement otp3;

@FindBy(xpath = "//*[@class='otp__digit field__4']")
WebElement otp4;

@FindBy(xpath = "//*[@class='otp__digit field__5']")
WebElement otp5;

@FindBy(xpath = "//*[@class='otp__digit field__6']")
WebElement otp6;

@FindBy(xpath = "//div[text()='Sign In']")
WebElement signin;

    public Login(WebDriver driver) {
        this.driver=(ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public void navigateToLoginPage() {
        driver.get(url);
    }

    public Boolean performLogin() throws InterruptedException {
     mobileNo.sendKeys(Mobile);
     Thread.sleep(20000);
     sendOTP.click();
     Thread.sleep(3000);
     otp1.sendKeys(OTP.substring(0,1));
     otp2.sendKeys(OTP.substring(1,2));
     otp3.sendKeys(OTP.substring(2,3));
     otp4.sendKeys(OTP.substring(3,4));
     otp5.sendKeys(OTP.substring(4,5));
     otp6.sendKeys(OTP.substring(5,6));
     signin.click();
     Thread.sleep(3000);
   return this.driver.getCurrentUrl().equals("https://staging.babymd.in/dashboard");
    }
}