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
    @FindBy(xpath="//li[text()='Status']") WebElement Hide_status;

    @FindBy(xpath="//a[@title='Add multiple tasks']") WebElement Add_addmultipletasks;
    @FindBy(xpath="//input[@name='title']") WebElement Add_title;
    @FindBy(xpath="//span[@class='select2-chosen' and @id='select2-chosen-28']") WebElement Add_dropdownproject;
    @FindBy(xpath="//li[@class='select2-results-dept-0 select2-result select2-result-selectable'][2]") WebElement Add_project;
    @FindBy(xpath="//button[@id='save-and-add-button']") WebElement Add_save;
    //@FindBy(xpath="//div[@class='modal-dialog modal-lg']/descendant::button[@class='btn-close']") WebElement Add_close;
    
    
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
		Thread.sleep(2000);
		Hide_id.click();		
	}
    
    public void HideTitle() throws InterruptedException
    {
//    	taskMenu.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
		Hide_hidebutton.click();
		Thread.sleep(2000);
		Hide_title.click();		
	}

    public void HideMilestone() throws InterruptedException
    {
//    	taskMenu.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
		Hide_hidebutton.click();
		Thread.sleep(2000);
		Hide_milestone.click();		
	}

    public void HideRelateto() throws InterruptedException
    {
//    	taskMenu.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
		Hide_hidebutton.click();
		Thread.sleep(2000);
		Hide_relateto.click();		
	}
    public void HideStatus() throws InterruptedException
    {
//    	taskMenu.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Thread.sleep(2000);
		Hide_hidebutton.click();
		Thread.sleep(2000);
		Hide_status.click();		
	}
    
    public void addMutipletask(String title) throws InterruptedException
    {
    	taskMenu.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Add_addmultipletasks);
		Thread.sleep(3000);
		Add_title.sendKeys(title);
		Add_dropdownproject.click();
		Thread.sleep(1000);
		Add_project.click();
		Add_save.click();
	}
    
}
