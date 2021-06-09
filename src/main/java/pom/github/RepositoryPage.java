package pom.github;

import controls.WebButton;
import controls.WebLink;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RepositoryPage extends AbstractPOM {
    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong[text()='Quick setup']")
    public WebTextBlock quickSetupHeader;

    @FindBy(xpath = "//strong[@class='mr-2 flex-self-stretch']/a")
    public WebLink repositoryName;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebButton settings;

    @FindBy(xpath = "//span[text()='Pull requests']")
    public WebButton pullRequests;

    @FindBy(xpath = "//span[text()='New pull request']")
    public WebButton newPullRequest;

    @FindBy(xpath = "//summary[contains(text(),'Delete this repository')]")
    public WebButton deleteRepository;

    @FindBy(xpath = "//form[contains(@action,'delete')]//input[@name='verify']")
    public WebTextInput nameOfRepoToBeDeleted;

    @FindBy(xpath = "//span[text()='I understand the consequences, delete this repository']")
    public WebButton iUnderstandTheConsequencesDeleteThisRepository;
}