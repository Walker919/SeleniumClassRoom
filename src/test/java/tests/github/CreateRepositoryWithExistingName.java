package tests.github;

import core.BaseTest;
import core.GitHub;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CreateRepositoryWithExistingName extends BaseTest {
    public void test() {

        GitHub gitHub = GitHub.init(driver);

        String repositoryName = "ApiTesting";
        gitHub.dashboard.newRepositoryButton.click();
        gitHub.createNewRepositoryPage.repositoryName.sendKeys(repositoryName);

        gitHub.createNewRepositoryPage.repoAlreadyExistErrorMessage.
                equals("The repository " + repositoryName + " already exists on this account.");

        Assert.assertFalse(gitHub.createNewRepositoryPage.createRepositoryButton.isEnabled(),
                "Element " + gitHub.createNewRepositoryPage.createRepositoryButton + " is Disabled");
    }
}