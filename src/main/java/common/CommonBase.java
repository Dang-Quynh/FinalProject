package common;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
/*
 * Author: Tran Hoan, mobile/zalo: +84-979535822
 * Initiate some common methods to testing purpose using relative wait
 * This class can be use after Day16 of my course to make more effective and stable test script
 * To handle Flaky test appearing due to some other Selenium Exception types
 * feel free contact HoanTran to get more detail strategies.
 */
public class CommonBase {
	public WebDriver driver;	
	public Duration initWaitTime = Duration.ofSeconds(10);
	public WebDriver initChromeDriver(String URL)
	{
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "\\driver\\chromedriver.exe");		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) {
		WebElement element = driver.findElement(inputElement);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptInnerHTML(inputElement, companyName);
		}
	}
	
	public void inputTextJavaScriptValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptValue(locator, value);
		}
	}
	
	public void scrollToElement(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement getElementPresentDOM(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
		return driver.findElement(locator);
	}
	
	public boolean isElementPresent(By locator)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
		return getElementPresentDOM(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("can not find element");
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
			System.out.println("can not find element");
			return false;
		}
	}
	public void click(By locator)
	{
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	public void type(By locator, String value)
	{
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}
	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get absolute path of file
	 * 
	 * @param relativeFilePath
	 * @return
	 */
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		return absolutePath;
	}

	public void quitDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			dr.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS); 
			dr.manage().deleteAllCookies();
			dr.close();
		}
	}
	public WebDriver initChromeDriver()
	{
		System.out.println("Launching chrome brower");
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "\\driver\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		// wait 30s unit web load success
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver initFirefoxDriver()
	{
		System.out.println("Launching firefox brower");
		System.setProperty("webdriver.firefox.driver",
		System.getProperty("user.dir") + "\\driver\\geckodriver.exe");		
		FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("headless");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
	
		// wait 30s unit web load success
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver initMSEdgeDriver()
	{
		System.out.println("Launching MSEdge brower");
		System.setProperty("webdriver.edge.driver",
		System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");		
		EdgeOptions options = new EdgeOptions();
		//options.addArguments("headless");
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		// wait 30s unit web load success
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver setupDriver(String browserName)
	{
		switch(browserName.trim().toLowerCase())
		{
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;	
		case "edge":
			driver = initMSEdgeDriver();
			break;
		}
		return driver;
	}
}
