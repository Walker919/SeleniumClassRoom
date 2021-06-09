package pom.wp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;

public class AddNewPost extends AbstractPOM{
	
	public AddNewPost(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='wrap']/h1")
	public WebTextBlock pageNameLabel;
	
	@FindBy(xpath = "//input[@name='post_title']")
	public WebTextInput postTitleInput;
	
	@FindBy(xpath = "//textarea[@name='content']")
	public WebTextInput contentInput;
}
