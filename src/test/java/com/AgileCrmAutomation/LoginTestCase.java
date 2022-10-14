package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmPages.LoginPage;

public class LoginTestCase extends BaseClass {
	//@Test(groups = { "sanity" })
	//@Parameters({ "browser", "username", "password" })
	public void a_login(String browser, String username, String password) {
		LoginTestCase Login = new LoginTestCase();
		Login.launchBrowser(browser);
		driver.navigate().to("https://rolex.agilecrm.com");
		LoginPage loginuser = new LoginPage();
		System.out.println(" Testcase1- username and valid password");
		loginuser.login(username, password);
		Login.condition();
		System.out.println("Testcase2-unvalid username and valid password");
		loginuser.login("cst47@yopmail.com", "Test1234");
		Login.condition();
		System.out.println("Testcase3-unvalid username and valid password");
		loginuser.login("cst1@yopmail.org", "Test1234");
		Login.condition();
		System.out.println("Testcase4-unvalid username with spaces and valid password");
		loginuser.login("  cst1@yopmail.com", "Test1234");
		Login.condition();
		loginuser.forgotpassword();
	}

	public void condition() {
		if (driver.findElement(By.xpath("//a[@class='close']")).isDisplayed())// error massage found clear data and
																				// enter new test case data
		{
			System.out.println("Invalid Creditial");

		} else {
			System.out.println("Login sucessfully");
			LoginPage logout = new LoginPage();// after login logout
			logout.logout();
		}
	}
}