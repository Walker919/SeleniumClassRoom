package tests.github;

import core.BaseTest;
import core.GitHub;
import org.testng.annotations.Test;

@Test
public class ValidatePullRequestButtonPresence extends BaseTest {
    public void test(){

        GitHub gitHub = GitHub.init(driver);

        gitHub.dashboard.mainRepository.click();
        gitHub.repositoryPage.pullRequests.click();

        gitHub.repositoryPage.newPullRequest.checkIfDisplayed();
    }
}