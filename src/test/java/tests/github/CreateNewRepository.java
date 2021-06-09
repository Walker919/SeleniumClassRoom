package tests.github;

import core.BaseTest;
import core.GitHub;
import core.Helpers;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class CreateNewRepository extends BaseTest {
    public void test() throws IOException {

        GitHub gitHub = GitHub.init(driver);

        String repositoryName = Helpers.randomAlphabetic(10);
        gitHub.dashboard.newRepositoryButton.click();
        gitHub.createNewRepositoryPage.repositoryName.sendKeys(repositoryName);
        gitHub.createNewRepositoryPage.description.sendKeys(Helpers.randomAlphabetic(50));

        Helpers.click(driver, gitHub.createNewRepositoryPage.createRepositoryButton, gitHub.createNewRepositoryPage.createRepositoryButton);

        gitHub.repositoryPage.quickSetupHeader.checkIfDisplayed();
        gitHub.repositoryPage.repositoryName.equals(repositoryName);
    }
}