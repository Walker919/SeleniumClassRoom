package pom.wp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;

public class LoginPage extends AbstractPOM{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='user_login']")
	public WebTextInput userNameInput;
	
	@FindBy(id = "user_pass")
	public WebTextInput userPassInput;
	
	@FindBy(id = "wp-submit")
	public WebButton submitBtn;
	
	@FindBy(xpath = "//div[@id='login_error']")
	public WebTextBlock errorMsg;
	
	public void login(String strUserName, String strPasword) {
		userNameInput.sendKeys(strUserName);
		userPassInput.sendKeys(strPasword);
		submitBtn.click();
	}
}