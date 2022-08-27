package demoWebShop;

import org.testng.annotations.Test;

import pomRepository.LoginPage;
import pomRepository.WelcomePage;

public class LoginTest extends BaseTest{
	
	@Test
	public void testCase1() {
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.clickLogin();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmail("yogita");
		
	}

}
