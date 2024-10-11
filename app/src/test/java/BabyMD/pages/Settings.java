package BabyMD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class Settings {
    ChromeDriver driver;
    String url="https://staging.babymd.in/settings";

    String url2="https://staging.babymd.in/patient/124/goals/new";
    @FindBy(xpath="//div[text()='Global Configurations']")
    WebElement  globalConfig;

    @FindBy(xpath="//div[text()='Goal Creations']")
    WebElement  goalCreation;

    @FindBy(xpath = "//*[@placeholder='Goal Name']")
    WebElement goalName;

    @FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[4]/div[1]/img")
    WebElement addGoal;

    @FindBy(xpath="//*[@placeholder='Value']")
    WebElement targetValue;

    @FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[5]/div[3]/div/select")
    WebElement frequency;

    @FindBy(xpath ="//*[@placeholder='Message is sent after enabling the goal on user profile']")
    WebElement notificationTemplate;

    @FindBy(xpath ="//*[@placeholder='Reminder is sent everyday at 5pm for all the goals assigned to patients']")
    WebElement reminderTemplate; 

    @FindBy(xpath="//div[text()='Save']")
    WebElement save;

    @FindBy(xpath="//span[text()='Search Goal']")
    WebElement searchGoal;

    @FindBy(xpath ="//span[text()='Vaccination']")
    WebElement Vaccination;

    @FindBy(xpath ="//div[text()='Manage Categories / Tags']")
    WebElement ManageCategories;

    @FindBy(xpath="//div[text()='Notes Categories']")
    WebElement notescategories;

    @FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/input")
    WebElement notename;

    @FindBy(xpath = "//div[text()='Notes Templates']")
    WebElement notestemplate;

    @FindBy(xpath ="//span[text()='Select Category']")
    WebElement selectcategory;

    @FindBy(xpath="//span[text()='New Categories']")
    WebElement category;

    @FindBy(xpath="//*[@placeholder='Title']")
    WebElement notetitle;
@FindBy(xpath="//button[text()='Save']")
WebElement savebutton;

public Settings(WebDriver driver){
       this.driver = (ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
}

public void navigateToLandingPage() throws InterruptedException{
    driver.get(url);
    Thread.sleep(3000);
}
public void gotogoal() throws InterruptedException{
    driver.get(url2);
    Thread.sleep(3000);
}

public void addNewGoal() throws InterruptedException{
    globalConfig.click();
    Thread.sleep(2000);
    goalCreation.click();
    Thread.sleep(2000);
}



public void AddGoalDetails(){
    goalName.sendKeys("Test Goal");
    addGoal.click();
    targetValue.sendKeys("10");

}

public void frequencySelect(){
    Select select=new Select(frequency);
    select.selectByIndex(1);
}
public void AddNotification(){
    notificationTemplate.sendKeys("Every Saturday");
}

public void AddReminder(){
    reminderTemplate.sendKeys("Every Sunday");

}
public void saveDetails(){
    save.click();
}
public void goalname() throws InterruptedException{
    searchGoal.click();
    Thread.sleep(3000);
    Vaccination.click();
}


public void addNotecategory() throws InterruptedException{
    ManageCategories.click();
    Thread.sleep(2000);
notescategories.click();
Thread.sleep(2000);
notename.sendKeys("test Note");
Thread.sleep(2000);
save.click();
}


public void addNotetemplate() throws InterruptedException{
    ManageCategories.click();
    Thread.sleep(3000);
    notestemplate.click();
    Thread.sleep(2000);
    selectcategory.click();
    Thread.sleep(2000);
    category.click();
    Thread.sleep(2000);
    notetitle.sendKeys("Test Notes check");
    Thread.sleep(2000);
    savebutton.click();
}
}
