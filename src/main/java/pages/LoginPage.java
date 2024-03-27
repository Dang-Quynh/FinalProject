package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

	private WebDriver driver;
	@FindBy(id = "email") WebElement txtEmail;
	
	@FindBy(id ="password") WebElement txtPass;
	
	@FindBy(xpath = "//button[text()='Sign in']") WebElement btnSignin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction (String email, String pass)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
		txtPass.clear();
		txtPass.sendKeys(pass);
		
		btnSignin.click();
	}
}
