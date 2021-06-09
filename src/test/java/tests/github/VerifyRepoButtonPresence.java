package tests.github;

import core.BaseTest;
import core.GitHub;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyRepoButtonPresence extends BaseTest {
    public void test() {

        GitHub gitHub = GitHub.init(driver);

        Assert.assertTrue(gitHub.dashboard.newRepositoryButton.isElementPresent(),
                "Element " + gitHub.dashboard.newRepositoryButton.getName() + " is displayed");

        Assert.assertFalse(gitHub.dashboard.successfullyDeletedRepoMessage.isElementPresent(),
                "Element " + gitHub.dashboard.successfullyDeletedRepoMessage.getName() + " is NOT displayed");
    }
}