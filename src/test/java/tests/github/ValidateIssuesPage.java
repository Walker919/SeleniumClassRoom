package tests.github;

import core.BaseTest;
import core.GitHub;
import org.testng.annotations.Test;

@Test
public class ValidateIssuesPage extends BaseTest {
    public void test() {

        GitHub gitHub = GitHub.init(driver);

        gitHub.dashboard.issues.click();

        gitHub.issuesPage.createdSection.checkIfDisplayed();
        gitHub.issuesPage.mentionedSection.checkIfDisplayed();
        gitHub.issuesPage.assignedSection.checkIfDisplayed();
    }
}