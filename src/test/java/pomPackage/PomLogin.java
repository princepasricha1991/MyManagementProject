package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	
	@FindBy(id="user-name") WebElement Username;
	@FindBy(id="password") WebElement Password;
	@FindBy(id="login-button") WebElement LoginBtn;
	
	public PomLogin()
	{
		PageFactory.initElements(driver	, this);
	}
	public void typeUserName(String name) {
		Username.sendKeys(name);
	}
	public void typePassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public void clkButton() {
		LoginBtn.click();
	}
	public String verifyTitle() {
		return driver.getTitle();
	}

}
