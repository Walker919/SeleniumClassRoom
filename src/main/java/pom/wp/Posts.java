package pom.wp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebTextBlock;
import core.AbstractPOM;

public class Posts extends AbstractPOM{
	
	public Posts(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='wrap']/h1")//[text()='Posts']")
	public WebTextBlock pageNameLabel;
	
}
