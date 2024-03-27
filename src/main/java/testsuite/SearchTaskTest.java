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
	
	@Test //Search by ID TC_13
	public void searchTaskbyID() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3658");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//td/child::a[@data-id='3658']")).isDisplayed());
	}
	
	@Test //Search by Title TC_14 
	public void searchTaskbyTitle() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("Add company logo and contact details");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Add company logo and contact details']")).isDisplayed());
	}
	
	@Test //hide by id
	public void hidebyid() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		TaskPage task = new TaskPage(driver);
		task.searchBy("3290");
		Thread.sleep(3000);
		task.HideID();	
		By taskID = By.xpath("//td[@class=' w10p']//a[@data-id='3290']");
		isElementPresent(taskID);
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
