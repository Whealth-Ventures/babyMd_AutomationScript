package qtriptest.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import qtriptest.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HomePage {
    ChromeDriver driver;
    String url="https://qtripdynamic-qa-frontend.vercel.app/";

    
    @FindBy(xpath="//a[text()='Register']")
    WebElement registerButton;

    @FindBy(xpath="//div[text()='Logout']")
    WebElement logoutButton;

    @FindBy(id="autocomplete")
    WebElement searchBox;

    @FindBy(xpath="//h5[text()='No City found']")
    WebElement noCityfound;

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    
    public void gotoHomePage() throws InterruptedException {
       driver.get(url);
    }

    public void clickRegister() throws InterruptedException {
     registerButton.click();
    }

    public Boolean isUserLoggedIn() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void logOutUser() throws InterruptedException { 
     logoutButton.click();
    }

    public void searchCity(String cityName) {
        searchBox.clear();
       searchBox.sendKeys(cityName);
    }

    public void selectCity(String cityName) throws Exception {
        Thread.sleep(2000);
        By by = new By.ByXPath(String.format("//li[@id='%s']", cityName.toLowerCase()));
      //  WebElement x = SeleniumWrapper.findElementWithRetry(this.driver, by, 3);
         WebElement city = driver.findElement(By.xpath(String.format("//li[@id='%s']", cityName.toLowerCase())));
      //  SeleniumWrapper.click(x,this.driver);
    }

    public boolean isNoCityFound() {
        try {
            return noCityfound.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}


    

