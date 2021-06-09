package tests.github;

import core.BaseTest;
import core.GitHub;
import core.Helpers;
import org.testng.annotations.Test;

@Test
public class CreateAndDeleteRepository extends BaseTest {
    public void test() {

        GitHub gitHub = GitHub.init(driver);

        String repositoryName = Helpers.randomAlphabetic(10);
        gitHub.dashboard.newRepositoryButton.click();
        gitHub.createNewRepositoryPage.repositoryName.sendKeys(repositoryName);
        gitHub.createNewRepositoryPage.description.sendKeys(Helpers.randomAlphabetic(50));

        Helpers.click(driver, gitHub.createNewRepositoryPage.createRepositoryButton, gitHub.createNewRepositoryPage.createRepositoryButton);

        gitHub.repositoryPage.quickSetupHeader.checkIfDisplayed();
        gitHub.repositoryPage.repositoryName.equals(repositoryName);

        gitHub.repositoryPage.settings.click();
        gitHub.repositoryPage.deleteRepository.click();

        String fullRepoName = "Walker919/" + repositoryName;
        gitHub.repositoryPage.nameOfRepoToBeDeleted.sendKeys(fullRepoName);
        gitHub.repositoryPage.iUnderstandTheConsequencesDeleteThisRepository.click();

        gitHub.dashboard.successfullyDeletedRepoMessage.
                equals("Your repository \"" + fullRepoName + "\" was successfully deleted.");
    }
}