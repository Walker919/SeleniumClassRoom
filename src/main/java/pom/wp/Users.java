package pom.wp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebLink;
import controls.WebTextBlock;
import core.AbstractPOM;

public class Users extends AbstractPOM {

	public Users(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Users')]")
	public WebTextBlock pageTitle;
	
	@FindBy(xpath = "//h1/a[text()='Add New']")
	public WebLink addNewLnk;

}
