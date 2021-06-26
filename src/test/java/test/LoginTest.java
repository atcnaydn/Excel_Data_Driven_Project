package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader excelRead = new ExcelReader("src\\main\\java\\data\\TestData.xlsx");
	String username = excelRead.getCellData("Sheet1", "Username", 2);
	String password = excelRead.getCellData("Sheet1", "Password", 2);
	
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

	}

}
