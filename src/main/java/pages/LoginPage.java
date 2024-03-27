package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    @FindBy(id="email")
    WebElement txtEmail;

    @FindBy(id="password") WebElement txtPassword;

    @FindBy(xpath="//button[text()='Sign in']") WebElement btnSignin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginFunction(String email, String pass){
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPassword.clear();
        txtPassword.sendKeys(pass);

        btnSignin.click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
}
