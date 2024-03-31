package testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.CommonBase;
import constant.CT_Common;
import pages.*;





public class AddTask extends CommonBase {

//	@BeforeMethod
//	@Parameters("browserParamName")
//	public void openBrowser(@Optional("chrome") String browerValue) throws InterruptedException
//	{
//		setupDriver(browerValue);
//		driver.get(CT_Common.URL_rise_signin);
//	}
	
	@BeforeMethod
	public void browser() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_rise_signin);
		
	}
	
	
	@Test //Add task successfully
	public void addTaskSuccess() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.addTask("Chau test 123");
		//task.selectProject("Online Course Creation and Launch");
		Thread.sleep(2000);
		
		task.searchBy("Chau test 123");
		Thread.sleep(3000);
		//assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Chau test 123']")).isDisplayed());

	}
	
	@Ignore //Add task missing Required filed (Title)
	public void addtaskfail_missingfield() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.addTask("");
		assertTrue(driver.findElement(By.xpath("//div[@class=' col-md-9']//span[text()='This field is required.']")).isDisplayed());
		Thread.sleep(1000);
	}
	
	@Ignore //Edit task by adding 'Edit ' before title
	public void editTaskSuccess() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.editTask("Edit");
		Thread.sleep(3000);
//		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Chau test 123']")).isDisplayed());
	}
	
	@Ignore //Click 'Cancel' button 
	public void deleteTaskCancellation() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.deleteTaskcancel();
		Thread.sleep(2000);
//		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Chau test']")).isDisplayed());
	}
	
	@Ignore //Click 'Delete' button
	public void deleteTaskSuccess() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.deleteTask();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
        alert.dismiss();
//		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Chau test']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
