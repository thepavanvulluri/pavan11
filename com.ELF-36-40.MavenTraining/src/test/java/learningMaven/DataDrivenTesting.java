package learningMaven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import demoWebShop.BaseTest;

public class DataDrivenTesting extends BaseTest {
	
	
	
	@Test(dataProvider = "Login")
	public void testCase(String username, String password) throws InterruptedException {
		System.out.println(username);
		System.out.println(password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("User is navigated to the home page", true);
		driver.findElement(By.linkText("Log in")).click();
		Reporter.log("User is navigated to login page");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		Thread.sleep(2000);
		
		WebElement logoutLink=driver.findElement(By.linkText("Log out"));
		/*
		 * SoftAssert ast=new SoftAssert(); ast.assertEquals(logoutLink.isDisplayed(),
		 * true, "User is successfully logged in"); ast.assertEquals("Hello", "Hey");
		 * ast.assertAll();
		 */
		logoutLink.click();
		
	}
	
	@DataProvider(name="Login")
	public Object[][] testData() throws EncryptedDocumentException, IOException {
		
		ExcelLibrary lib=new ExcelLibrary();
		return lib.readMultipleData("Login");
		 		
	}

}
