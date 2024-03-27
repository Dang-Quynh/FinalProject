package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.CommonBase;
public class TaskPage {
	private WebDriver driver;
	
	@FindBy(xpath ="//span[text()='Tasks']") WebElement taskMenu;
    @FindBy(xpath = "//input[@type='search']") WebElement Search_searchbox;
    
    @FindBy(xpath ="//button[@class='btn btn-default column-show-hide-popover']") WebElement Hide_hidebutton;
    @FindBy(xpath="//li[text()='ID']") WebElement Hide_id;
    @FindBy(xpath="//li[text()='Title']") WebElement Hide_title;
    @FindBy(xpath="//li[text()='Start date']") WebElement Hide_startdate;
    @FindBy(xpath="//li[text()='Deadline']") WebElement Hide_deadline;
    @FindBy(xpath="//li[text()='Milestone']") WebElement Hide_milestone;
    @FindBy(xpath="//li[text()='Related to']") WebElement Hide_relateto;
    @FindBy(xpath="//li[text()='Assigned to']") WebElement Hide_assignedto;

    
    public TaskPage(WebDriver commonDriver) 
	{
		this.driver = commonDriver;
		PageFactory.initElements(commonDriver, this);	
	}
	

    // auth = huy
    public void searchBy(String key) throws InterruptedException
    {
    	taskMenu.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		Thread.sleep(2000);
		Search_searchbox.sendKeys(key);
	}
    
    public void HideID() throws InterruptedException
    {
//    	taskMenu.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
		Hide_hidebutton.click();
		Hide_id.click();		
	}





//    public void addMutipletask(String key) throws InterruptedException
//    {
//    	taskMenu.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
//		Search_searchbox.sendKeys(key);
//	}
    
}
