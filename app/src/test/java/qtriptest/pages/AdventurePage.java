// package qtriptest.pages;


// public class AdventurePage {
//     ChromeDriver driver;
//     String url="https://qtripdynamic-qa-frontend.vercel.app/";


//     @FindBy(id = "duration-select")
//     WebElement durationFilter;

//     @FindBy(id = "category-select")
//     WebElement categoryFilter;

//     @FindBy(xpath = "//div[@onclick='clearDuration(event)']")
//     WebElement clearDuration;

//     @FindBy(xpath = "//div[@onclick='clearCategory(event)']")
//     WebElement clearCategory;

//     public AdventurePage(ChromeDriver driver) {
//         this.driver = driver;
//         PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
//     }
// public void selectfilter(String value){
//     Select select = new Select(selectfilter);
//     select.selectByVisibleText(value);
// }

// public void selectCategory(String value){
//     Select select = new Select(categoryFilter);
//     select.selectByVisibleText("Adventure");
// }
// public void clearFilter(){
//     clearDuration.click();
//     clearCategory.click();
// }
// public void clearCategory(){
//     clearCategory.click();
// }
// public void clearDuration(){
//     clearDuration.click();
// }
// }