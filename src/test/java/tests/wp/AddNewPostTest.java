package tests.wp;

import static core.Helpers.check2StringIfEquals;

import org.testng.annotations.Test;

import core.BaseTest;
import pom.wp.AddNewPost;
import pom.wp.DashboardPage;
import pom.wp.LeftMenu;
import pom.wp.LoginPage;
import pom.wp.Posts;

@Test
public class AddNewPostTest extends BaseTest {
	
	public void test() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "admin_pass!");
		
		DashboardPage dp = new DashboardPage(driver);
		dp.pageTitle.checkIfDisplayed();
		
		LeftMenu lm = new LeftMenu(driver);
//		Helpers.click(driver, lm.postsLnk, lm.addNewPostLnk);
//		
//		Thread.sleep(5000);
//		
//		AddNewPost anp = new AddNewPost(driver);
//		Assert.assertTrue(anp.pageNameLabel.isDisplayed(), "Page label is displayed for Add New post page");
//		check2StringIfEquals(anp.pageNameLabel, "Add a New Post");
		
		lm.postsLnk.click();
		
		Posts posts = new Posts(driver);
		posts.pageNameLabel.checkIfDisplayed();
		lm.addNewPostNotHoverLnk.click();
		
		AddNewPost anp = new AddNewPost(driver);
		anp.pageNameLabel.equals("Add a New Post");
		anp.postTitleInput.sendKeys("My new post");
		anp.contentInput.sendKeysWithoutValidation("New content");
		
		
		Thread.sleep(5000);
	}
}