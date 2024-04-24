package qtriptest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import qtriptest.*;



public class LoginPage {
 ChromeDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";


    @FindBy(id="floatingInput")
    WebElement username_txt_box;

    @FindBy(xpath="//input[@id='floatingPassword']")
    WebElement password_text_box;

    @FindBy(xpath="//button[normalize-space()='Login to QTrip']")
    WebElement login_button;


    public LoginPage(ChromeDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public void navigateToLoginPage() {
    
        driver.get(url);
    
    }

    public Boolean performLogin(String username, String password) throws InterruptedException {
     
        username_txt_box.sendKeys(username);
   
        password_text_box.sendKeys(password);
        login_button.click();
      Thread.sleep(3000);

        return this.driver.getCurrentUrl().equals("https://qtripdynamic-qa-frontend.vercel.app/");
    }
}


