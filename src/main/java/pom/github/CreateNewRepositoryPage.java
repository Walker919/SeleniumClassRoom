package pom.github;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateNewRepositoryPage extends AbstractPOM {
    public CreateNewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='repository_name']")
    public WebTextInput repositoryName;

    @FindBy(xpath = "//button[contains(text(),'Create repository')]")
    public WebButton createRepositoryButton;

    @FindBy(xpath = "//input[@id='repository_description']")
    public WebTextInput description;

    @FindBy(xpath = "//dd[contains(@id,'input-check')]")
    public WebTextBlock repoAlreadyExistErrorMessage;
}