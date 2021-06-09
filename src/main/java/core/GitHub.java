package core;

import org.openqa.selenium.WebDriver;
import pom.github.*;

public class GitHub {

    private static GitHub gitHub;

    public Dashboard dashboard;
    public GitHubHomePage gitHubHomePage;
    public SignInPage signInPage;
    public CreateNewRepositoryPage createNewRepositoryPage;
    public RepositoryPage repositoryPage;
    public IssuesPage issuesPage;

    private GitHub(WebDriver driver) {
        dashboard = new Dashboard(driver);
        gitHubHomePage = new GitHubHomePage(driver);
        signInPage = new SignInPage(driver);
        createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        repositoryPage = new RepositoryPage(driver);
        issuesPage = new IssuesPage(driver);
    }

    public static GitHub init(WebDriver driver) {
        if (gitHub == null) {
            gitHub = new GitHub(driver);
        }
        return gitHub;
    }
}