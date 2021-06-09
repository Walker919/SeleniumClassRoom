package pom.github;

import controls.WebButton;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage extends AbstractPOM {
    public GitHubHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    public WebButton signIn;
}
