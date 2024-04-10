package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonBase {
    public WebDriver driver;
    public int initWaitTime = 10;
    public WebDriverWait wait;

    public WebDriver setupDriver(String browserName) throws InterruptedException {
        switch (browserName){
            case "chrome":{
                driver = initChromeDriver();
                break;
            }
            case "firefox":{
                driver = initFirefoxDriver();
                break;
            }
            case "edge":{
                driver = initEdgeDriver();
                break;
            }
            default:
                System.out.println("BrowserName was incorrect!");
                driver = initChromeDriver();
                break;
        }
        return driver;
    }

    public WebDriver initChromeDriver() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        System.out.println("Launching chrome ...");
        WebDriverManager webDriverManager = WebDriverManager.chromedriver();
        webDriverManager.clearDriverCache();
        webDriverManager.setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*", "--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        return driver;
    }

    public WebDriver initFirefoxDriver() throws InterruptedException {
        System.out.println("Launching Firefox ...");

        WebDriverManager webDriverManager = WebDriverManager.firefoxdriver();
//        webDriverManager.clearDriverCache();
        webDriverManager.setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        return driver;
    }

    public WebDriver initEdgeDriver() throws InterruptedException {
        System.out.println("Launching edge ...");
        WebDriverManager webDriverManager = WebDriverManager.edgedriver();
        webDriverManager.clearDriverCache();
        webDriverManager.setup();

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        return driver;
    }

    public WebDriver initChromeDriver(String url) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        System.out.println("Launching chrome ...");
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
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
        WebElement element = getElement(locator);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            inputTextJavaScriptValue(locator, value);
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = getElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<WebElement> getElements(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public boolean isElementPresent(By locator)
    {
        wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
        return getElement(locator).isDisplayed();
    }

    public void clickElement(By locator)
    {
        WebElement element = getElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void clickElementByJS(By locator)
    {
        WebElement element = getElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void sendKeysElement(By locator, String value)
    {
        WebElement element = getElement(locator);
        element.sendKeys(value);
    }

    public void sendKeysElement(By locator, Keys value)
    {
        WebElement element = getElement(locator);
        element.sendKeys(value);
    }

    public Alert getAlert()
    {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
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

    public void closeDriver(WebDriver dr) {
        if (dr.toString().contains("null")) {
            System.out.print("All Browser windows are closed ");
        } else {
            dr.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
            dr.manage().deleteAllCookies();
            dr.close();
        }
    }

    public void quitDriver(WebDriver dr) {
        if (dr.toString().contains("null")) {
            System.out.print("All Browser windows are closed ");
        } else {
            dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            dr.manage().deleteAllCookies();
            dr.quit();
        }
    }

}
