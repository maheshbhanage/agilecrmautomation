package com.AgileCrmAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmPages.DealPage;
import com.AgileCrmPages.LoginPage;

public class DealsPageTestCase extends BaseClass {
	static DealPage Deals = new DealPage();

	@BeforeClass(groups = { "regression" })
	@Parameters({ "browser", "username", "password" })
	public void A_login(String browser, String username, String password) {
		LoginPage login = new LoginPage();
		login.launchBrowser(browser);
		driver.navigate().to("https://rolex.agilecrm.com");
		login.login(username, password);
		System.out.println("login successfully");
	}

@Test(priority = 1,groups = { "regression" })
	public void Dealscreate() throws Exception {
		for (int i = 1; i <= 10; i++) {
			String name = ("Deal" + i);
			String price = ("10000" + i);
			Deals.Adddeals(name, price);
			System.out.println("create deal successfully");
		}
	}

	@Test(priority=2,groups = { "regression" })
	public void changestatus() throws Exception {
		Deals.changeDealsStatus("New", "Won", "1");
		System.out.println("change deal status successfully");
	}

	@AfterClass(groups = { "regression","sanity"})
	public void logout() {
		LoginPage login = new LoginPage();
		login.logout();
		System.out.println("logout successfully");
	}
}
