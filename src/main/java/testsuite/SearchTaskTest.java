package testsuite;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.CommonBase;
import constant.CT_Common;
import pages.*;

public class SearchTaskTest extends CommonBase {
	@BeforeMethod
	@Parameters("browserParamName")
	public void openBrowser(@Optional("chrome") String browerValue) throws InterruptedException
	{
		setupDriver(browerValue);
		driver.get(CT_Common.URL_rise_signin);
	}
	
	@Test //add mutiple task success TC2
	public void addmutipletasksuccess() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.addMutipletask("huylq");
		Thread.sleep(3000);
		By close = By.xpath("//button[@class='btn btn-default'][1]");
		click(close);
		Thread.sleep(2000);
		task.searchBy("huylq");
		Thread.sleep(2000);
		//By tasknew = By.xpath("//td/child::a[text()='huylq']");
		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='huylq']")).isDisplayed());
	}
	
	@Test //add mutiple task fail TC1
	public void addmutipletaskfail1() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.addMutipletask("");
		assertTrue(driver.findElement(By.xpath("//div[@class=' col-md-9']//span[text()='This field is required.']")).isDisplayed());
	}
	
	@Test //add mutiple task fail TC4
	public void addmutipletaskfail2() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.addMutipletask("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		assertTrue(driver.findElement(By.xpath("//div[@class=' col-md-9']//span[text()='This field can not allow input more than 256 characters.']")).isDisplayed());
	}
	
	@Test //Search by ID TC_13
	
	public void searchTaskbyID() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3546");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//td/child::a[@data-id='3546']")).isDisplayed());
	}
	
	@Test //Search by Title TC_14 
	
	public void searchTaskbyTitle() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("A/B test ad variations");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='A/B test ad variations']")).isDisplayed());
	}
	
	@Test //Search by Milestone TC_15
	
	public void searchTaskbyMilestone() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("Beta Release");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//tr[@class='odd']/child::td[text()='Beta Release']")).isDisplayed());
	}
	
	@Test //Search by Related to TC_16
	
	public void searchTaskbyRelatedto() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("Virtual Reality Experience Design");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Virtual Reality Experience Design']")).isDisplayed());
	}
	@Test //hide by id TC_17
	public void hidebyid() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3290");
		Thread.sleep(3000);
		task.HideID();
		Thread.sleep(2000);
		By taskID = By.xpath("//td[@class=' w10p']//a[@data-id='3290']");
		//isElementPresent(taskID);
		assertFail(isElementPresent(taskID));
	}

	private void assertFail(boolean elementPresent) {
		// TODO Auto-generated method stub
		
	}

	@Test //hide by Title TC_18
	public void hidebytitle() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3290");
		Thread.sleep(3000);
		task.HideTitle();	
		Thread.sleep(2000);
		By tasktitle = By.xpath("//td/child::a[@title='Task info #3290']");
		isElementPresent(tasktitle);
	}
	
	@Test //hide by Milestone TC_21
	public void hidebymilestone() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3290");
		Thread.sleep(3000);
		task.HideMilestone();	
		Thread.sleep(2000);
		By taskmilestone = By.xpath("//tr[@class='odd']/child::td[text()='Release']");
		isElementPresent(taskmilestone);
	}
	
	@Test //hide by Related to TC_22
	public void hidebyrelatedto() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3290");
		Thread.sleep(3000);
		task.HideRelateto();	
		Thread.sleep(2000);
		By taskrelateto = By.xpath("//td/child::a[text()='Mobile App Development']");
		isElementPresent(taskrelateto);
	}
	
	@Test //hide by status TC_24
	public void hidebystatus() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3290");
		Thread.sleep(3000);
		task.HideStatus();	
		Thread.sleep(2000);
		By taskstatus = By.xpath("//td/child::a[@data-act='update-task-status']");
		isElementPresent(taskstatus);
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
