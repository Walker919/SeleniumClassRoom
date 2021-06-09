package core;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.github.Dashboard;
import pom.github.GitHubHomePage;
import pom.github.SignInPage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class);
    protected static WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        log.info("Open browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        String url = "http://testing.webtic.info/wordpress/wp-login.php";
        String url = "https://github.com";
        log.info("Navigate to: " + url);
        driver.get(url);

        logInMethod();
    }

    public void logInMethod() throws IOException {
        GitHubHomePage gitHubHomePage = new GitHubHomePage(driver);
        gitHubHomePage.signIn.click();

        SignInPage signInPage = new SignInPage(driver);

        signInPage.userNameField.sendKeysWithoutValidation(Helpers.getProperty("user"));
        signInPage.passwordField.sendKeysWithoutValidation(Helpers.getProperty("password"));
        signInPage.signInButton.click();
        waitForPageLoad();

        Dashboard dashboard = new Dashboard(driver);
        dashboard.avatarUser.checkIfDisplayed();
    }

    @AfterClass
    public void close() {
        takeScreenshot();
        driver.close();
    }

    public static void takeScreenshot() {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        LocalDateTime timePoint = LocalDateTime.now();
        String name = "screens/screenshot " + timePoint.get(ChronoField.YEAR_OF_ERA) + "-" + timePoint.getMonth() + "-" + timePoint.getDayOfMonth() + "--" + timePoint.getHour() + "-" + timePoint.getMinute() + "-" + timePoint.getSecond() + ".png";
        File DestFile = new File(name);
        log.info("Screenshot name is " + name);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageLoad() {
        new WebDriverWait(driver, 20).until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        log.info("Page Loaded");
    }
}