package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTF;
	
	public WebElement getEmailTF() {
		return emailTF;
	}

	public void setEmailTF(WebElement emailTF) {
		this.emailTF = emailTF;
	}

	public void enterEmail(String email) {
		emailTF.sendKeys(email);
	}
	
	@FindBy(id = "Password")
	WebElement passwordTF;
	
	public void enterPassword(String pwd) {
		passwordTF.sendKeys(pwd);
	}
	

}
