package tests.wp;

import org.testng.annotations.Test;

import core.BaseTest;
import pom.wp.DashboardPage;
import pom.wp.LeftMenu;
import pom.wp.LoginPage;
import pom.wp.Users;
@Test
public class AddNewUser extends BaseTest {
	
	public void test() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "admin_pass!");
		
		DashboardPage dp = new DashboardPage(driver);
		dp.pageTitle.checkIfDisplayed();
		
		LeftMenu lm = new LeftMenu(driver);
		lm.usersLnk.click();
		
		Users users = new Users(driver);
		users.pageTitle.checkIfDisplayed();
		users.addNewLnk.click();
		
		Thread.sleep(2000);
	}
}
