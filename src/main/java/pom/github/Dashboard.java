package pom.github;

import controls.WebButton;
import controls.WebTextBlock;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends AbstractPOM {
    public Dashboard(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//summary[@class='Header-link']//img[@alt='@Walker919']")
    public WebTextBlock avatarUser;

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-primary color-text-white'])[1]")
    public WebButton newRepositoryButton;

    @FindBy(xpath = "//div[@class='container-lg px-2']")
    public WebTextBlock successfullyDeletedRepoMessage;

    @FindBy(xpath = "//a[contains(text(),'Issues')]")
    public WebButton issues;

    @FindBy(xpath = "(//a[contains(@href,'Walker919/ApiTesting')])[1]")
    public WebButton mainRepository;
}