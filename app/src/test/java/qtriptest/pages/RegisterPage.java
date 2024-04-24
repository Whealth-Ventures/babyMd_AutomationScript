package qtriptest.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.UUID;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import qtriptest.*;


public class RegisterPage {
ChromeDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";
    public String lastGeneratedUsername = "";

    @FindBy(id="floatingInput")
    WebElement username_txt_box;

    @FindBy(xpath="(//input[@id='floatingPassword'])[1]")
    WebElement password_text_box;

    @FindBy(xpath="(//input[@id='floatingPassword'])[2]")
    WebElement confirm_password_txt_box;

    @FindBy(xpath="//button[@type='submit']")
    WebElement register_now_button;

    public RegisterPage(ChromeDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public Boolean registerUser(String username, String password, Boolean makeUserDynamic) throws InterruptedException {

        String test_data_username;
        if (makeUserDynamic)
            // Concatenate the timestamp to string to form unique timestamp
            test_data_username = username + UUID.randomUUID().toString();
        else
            test_data_username = username;

     
        username_txt_box.sendKeys(test_data_username);
    
        password_text_box.sendKeys(password);
      confirm_password_txt_box.sendKeys(password);
   register_now_button.submit();

        this.lastGeneratedUsername = test_data_username;

      Thread.sleep(3000);
        return this.driver.getCurrentUrl().endsWith("/login");
    }
    
}
