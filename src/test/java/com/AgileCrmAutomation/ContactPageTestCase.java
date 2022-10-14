package com.AgileCrmAutomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmPages.ContactPage;
import com.AgileCrmPages.LoginPage;

public class ContactPageTestCase extends BaseClass {
	
	@BeforeClass(groups = { "regression","sanity" })
	@Parameters({"browser","username","password"})
	public void login(String browser, String username, String password) {
		LoginPage loginuser = new LoginPage();
		ContactPageTestCase Login = new ContactPageTestCase();
		Login.launchBrowser(browser);
		driver.navigate().to("https://rolex.agilecrm.com");
		loginuser.login(username, password);
		System.out.println("Login the user");
	}

	@Test(priority = 1,groups = {"regression","sanity"})
	public void addcontact() {
		 ContactPage contact = new ContactPage();
		contact.addcontact("mahesh","bhanage");
		System.out.println("Add new contact");
	}

	@Test(priority = 2,groups = {"regression"})
	public void searchcontact() {
		 ContactPage contact = new ContactPage();
		contact.searchContact("");
		System.out.println("search contact");
	}

	@Test(priority = 3,groups = {"regression"})
	public void updatecontact() {
		 ContactPage contact = new ContactPage();
		contact.upadatecontact("mahi123");
		System.out.println("update contact");
	}

	@Test(priority = 4,groups = {"regression"})
	public void deletecontact() {
		 ContactPage contact = new ContactPage();
		contact.deletecontact();
		System.out.println("delete contact");
	}

	@AfterClass(groups = {"regression","sanity"})
	public void logout() {
		LoginPage loginuser = new LoginPage();
		loginuser.logout();
		System.out.println("logout successfully");
	}
}