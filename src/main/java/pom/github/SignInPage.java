package pom.github;

import controls.WebButton;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPOM {
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='login_field']")
    public WebTextInput userNameField;

    @FindBy(xpath = "//input[@id='password']")
    public WebTextInput passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebButton signInButton;
}