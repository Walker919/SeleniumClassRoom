package tests.wp;

import org.testng.annotations.Test;

import core.BaseTest;
import pom.wp.DashboardPage;
import pom.wp.LoginPage;

@Test
public class LoginTest extends BaseTest {
	
	public void test(){
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "admin_pass!");
		
		DashboardPage dp = new DashboardPage(driver);
		dp.pageTitle.equals("Dashboard");
		dp.welcomeMsg.equals("Welcome to WordPress!");
	}
}
