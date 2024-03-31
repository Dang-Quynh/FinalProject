package pages;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskPage {
	private WebDriver driver;
	
	private int initWaitTime = 30;
	
	@FindBy(xpath ="//span[text()='Tasks']") WebElement taskMenu;
    //@FindBy(xpath = "//input[@type='search']") WebElement Search_searchbox;
    @FindBy(xpath = "//a[text()=' Add task']") WebElement btnAddTask;
    
    @FindBy(xpath = "//button[@type='submit']") WebElement Save_button;
    @FindBy(id = "save-and-show-button" ) WebElement SaveShow_button;
    @FindBy(xpath="(//button[@class='btn btn-default'])[1]") WebElement Close_button;
    @FindBy(xpath = "//input[@name='title']") WebElement txtTitle;
    @FindBy(id = "description" ) WebElement txtDescription;
    
    @FindBy(xpath = "//div[@id='s2id_project_id']") WebElement project_dropdown;
    @FindBy(xpath = "//div/input[@id='s2id_autogen28_search']") WebElement project_search;
    
    @FindBy(xpath = "//div[@id='s2id_assigned_to']") WebElement assign_dropdown;
    @FindBy(xpath = "//div/input[@id='s2id_autogen115_search']") WebElement assign_search;
    
    
    @FindBy(xpath = "//div[@id='task-table_filter']//input[@placeholder='Search']") WebElement txtSearch;
    
    @FindBy(id = "recurring") WebElement checkboxRecurring;
    
    @FindBy(xpath = "(//table[@id='task-table']//td[10]//a[@class='edit'])") WebElement edit_button;
    @FindBy(xpath = "(//table[@id='task-table']//td[10]//a[@class='delete'])") WebElement delete_button;
    @FindBy(xpath = "//button[@id='confirmDeleteButton']") WebElement confirmdelete_button;
    @FindBy(xpath = "(//button[@type='button'])[18]") WebElement canceldelete_button;

    

    



    public TaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
	public void addTask(String task) throws InterruptedException 
	{
		taskMenu.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnAddTask);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		
        wait.until(ExpectedConditions.visibilityOf(txtTitle));
        
		txtTitle.sendKeys(task);
		txtDescription.sendKeys("asdfgfd");
		
		
		selectProject("Online Course Creation and Launch");
		Thread.sleep(3000);
		
		
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", checkboxRecurring);
		wait.until(ExpectedConditions.visibilityOf(checkboxRecurring));
		
		if (checkboxRecurring.isDisplayed()== true && checkboxRecurring.isSelected() == false)
			{
			checkboxRecurring.click();
			}
		
		
		selectPerson("John Doe");
		Thread.sleep(3000);
	
		
		
		Save_button.click();
		Thread.sleep(3000);
		

//		taskMenu.click();
//		Thread.sleep(3000);
		
		//txtSearch.sendKeys(task);
	}

	
		public void editTask(String editinfo) throws InterruptedException 
		{
			
			//taskMenu.click();
			searchBy("31/3 test");
			//searchBy("Chau test 123");
			Thread.sleep(3000);
	        // Click on the edit button to open the edit form
			edit_button.click();
			
			Thread.sleep(2000);
			
			//txtTitle.clear();
			txtTitle.sendKeys("Edit ");

			Save_button.click();
			
		}

		public void deleteTaskcancel() throws InterruptedException 
		{
			
			//taskMenu.click();
			searchBy("Add company logo and contact details");
			
			Thread.sleep(2000);
	        // Click on the delete button to open the delete popup
			delete_button.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(canceldelete_button));
			canceldelete_button.click();
			
		}
		
		public void deleteTask() throws InterruptedException 
		{
			
			//taskMenu.click();
			searchBy("3615");
			
			Thread.sleep(2000);
	        // Click on the delete button to open the delete popup
			delete_button.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOf(confirmdelete_button));
			confirmdelete_button.click();

		}
		
		public void selectProject(String projectName) {
		    // Click on the project dropdown button to open the dropdown
	    	project_dropdown.click();

	        // Clear any existing text in the input field
	    	project_search.clear();

	        // Type the desired project name into the input field
	    	project_search.sendKeys(projectName);

	        // Send TAB key to confirm the selection
	    	project_search.sendKeys(Keys.TAB);
			
		}

		public void selectPerson(String assignName) {
		    // Click on the project dropdown button to open the dropdown
			assign_dropdown.click();

	        // Clear any existing text in the input field
			assign_search.clear();

	        // Type the desired project name into the input field
			assign_search.sendKeys(assignName);

	        // Send TAB key to confirm the selection
			assign_search.sendKeys(Keys.TAB);
			
		}
		
	    public void searchBy(String key) throws InterruptedException
	    {
	    	taskMenu.click();
	    	Thread.sleep(2000);
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
	    	wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
	    	txtSearch.sendKeys(key);
		}
}
