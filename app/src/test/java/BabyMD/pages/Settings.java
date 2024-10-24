package BabyMD.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tr[1]/td[2]/div/div/div[2]/div")
WebElement editGoal;

@FindBy(xpath ="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tr[1]/td[2]/div/div/div[3]/div")
WebElement deleteGoal;

@FindBy(xpath = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]/div")
WebElement editCategory;

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[2]/div/div[2]/div[1]")
WebElement UpdateCategory;

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[3]/div/div/table/tbody/tr[1]/td[2]/div/div[2]/div[2]/div")
WebElement deleteCategory; 
@FindBy(xpath="//div[text()='Update']")
WebElement update;
   // Find all elements with class name "rs-dropdown-item"
   @FindBys({
    @FindBy(className = "rs-dropdown-item")
})
List<WebElement> dropdown;

@FindBy(xpath = "//div[text()='Record Payment']")
WebElement paymentrecord;


@FindBy(xpath="//span[text()='Select']")
WebElement select;


public Settings(WebDriver driver){
       this.driver = (ChromeDriver) driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
}

public void navigateToLandingPage() throws InterruptedException{
    driver.get(url);
    Thread.sleep(3000);
}
// public void gotogoal() throws InterruptedException{
//     driver.get(url2);
//     Thread.sleep(3000);
// }

public void addNewGoal() throws InterruptedException{
    globalConfig.click();
    Thread.sleep(2000);
    goalCreation.click();
    Thread.sleep(2000);
}



public void AddGoalDetails(String GoalName,String target){
    goalName.sendKeys(GoalName);
    addGoal.click();
    targetValue.sendKeys(target);

}

public void frequencySelect(){
    Select select=new Select(frequency);
    select.selectByIndex(1);
}
public void AddNotification(String Notification){
    notificationTemplate.sendKeys(Notification);
}

public void AddReminder(String reminder){
    reminderTemplate.sendKeys(reminder);

}
public void saveDetails(){
    save.click();
}
// public void goalname() throws InterruptedException{
//     searchGoal.click();
//     Thread.sleep(3000);
//     Vaccination.click();
// }


public void addNotecategory(String NoteName) throws InterruptedException{
    ManageCategories.click();
    Thread.sleep(2000);
notescategories.click();
Thread.sleep(2000);
notename.sendKeys(NoteName);
Thread.sleep(2000);
save.click();
}

// edit goal
public void editGoal() throws InterruptedException{
    editGoal.click();
    Thread.sleep(2000);
    update.click();
    Thread.sleep(2000);
    deleteGoal.click();
    Alert alert=driver.switchTo().alert();
    alert.accept();
    Thread.sleep(2000);
}
//edit notes category
public void editNoteCategory() throws InterruptedException{
    editCategory.click();
    Thread.sleep(2000);
   UpdateCategory.click();
    Thread.sleep(2000);
    deleteCategory.click();
    Thread.sleep(2000);
    Alert alert=driver.switchTo().alert();
    alert.accept();
    Thread.sleep(2000);
}


// public void addNotetemplate(String Title) throws InterruptedException{
//     ManageCategories.click();
//     Thread.sleep(3000);
//     notestemplate.click();
//     Thread.sleep(2000);
//     selectcategory.click();
//     Thread.sleep(2000);
//     category.click();
//     Thread.sleep(2000);
//     notetitle.sendKeys(Title);
//     Thread.sleep(2000);
//     savebutton.click();
// }


}
