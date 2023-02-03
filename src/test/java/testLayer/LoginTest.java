package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pomPackage.PomLogin;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	PomLogin Log;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		iniate();
		screenShot("Login");
		Log = new PomLogin();
	}
	
	@Test
	public void verify() {
		String actual = Log.verifyTitle();
		Assert.assertEquals(actual, "Swag Labs");
		System.out.println(actual);
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][] = ExcelSheet.readData("Sheet1");
		return result;
	}
	
	@Test(dataProvider = "Details")
	public void Login(String name, String password ) {
		Log.typeUserName(name);
		Log.typePassword(password);
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
