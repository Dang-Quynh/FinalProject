package common;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
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

public class CommonBase {
	public WebDriver driver;
	public Duration initWaitTime = Duration.ofSeconds(10);
	
	public WebDriver initChromeDriver(String URL)throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		// Đợi trong vòng 30 giây cho tới khi trang web load thành công
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
}
	
	public WebElement getElementPresentDOM(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
		return driver.findElement(locator);
	}
	
	
	public void click(By locator)
	{
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public boolean isElementPresent(By locator)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
			wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
			return getElementPresentDOM(locator).isDisplayed();
		}
		catch (org.openqa.selenium.NoSuchElementException e)
		{
			return false;
					
		}
		catch (org.openqa.selenium.TimeoutException e2)
		{
			return false;
		}
	}
	
	public WebDriver initChromeDriver()
	{
		System.out.println("Launching chrome browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		//driver.get(URL);
		// Đợi trong vòng 30 giây cho tới khi trang web load thành công
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
		
	}
	
	public WebDriver initFirefoxDriver()
	{
		System.out.println("Launching firefox browser");
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/driver/geckodriver 3");
		
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("headless");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		//driver.get(URL);
		// Đợi trong vòng 30 giây cho tới khi trang web load thành công
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		//explicit
		//Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    
		return driver;
		
	}
	
	public WebDriver initMsEdgeDriver()
	{
		System.out.println("Launching Edge browser");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		EdgeOptions option = new EdgeOptions();
		option.addArguments("headless");
		
		//driver.get(URL);
		// Đợi trong vòng 30 giây cho tới khi trang web load thành công
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
		
	}
	
//	private WebDriver initSafariDriver()
//	{
//		System.out.println("Launching Edge browser");
//		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver/chromedriver");
//		driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		return driver;
//	}

	
	public WebDriver setupDriver(String browserName)
	{
		switch(browserName.trim().toLowerCase())
		{
		case "chrome": driver = initChromeDriver();
		break;
		case "firefox": driver = initFirefoxDriver();
		break;
		case "edge": driver = initMsEdgeDriver();
		break;
		default:
			System.out.println("Browser "+ browserName + "was incorrect, run default chrome browser");
			driver = initChromeDriver();
		}
		
		return driver;
		
	}
	
}
