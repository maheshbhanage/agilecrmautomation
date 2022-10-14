package com.AgileCrmAutomation;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmPages.CompanyPage;
import com.AgileCrmPages.LoginPage;

public class ComponyPageTestCase extends BaseClass {
    @DataProvider(name="getLoginTestData")
    public Object[][] dataproviderMethod(){
	 return new Object[][]{{"add dropdown in mail in compony"}};
    }
	@BeforeClass(groups = {"regression"})
	@Parameters({ "browser", "username", "password" })
	public void alogin(String browser, String username, String password) {
		ComponyPageTestCase company = new ComponyPageTestCase();
		 LoginPage login1 = new LoginPage();
		company.launchBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://rolex.agilecrm.com");
		login1.login(username, password);
		System.out.println("login successfully");
	}

	@Test(groups = {"regression","sanity"},dataProvider="getLoginTestData")
	public void addcomponymaildropdown(String val) {
		 CompanyPage addCompany = new CompanyPage();
		addCompany.addcomponymaildropdown();
		System.out.println(val);
	}

	@Test(priority = 1)
	public void addcomponycountrydropdown() {
		 CompanyPage addCompany = new CompanyPage();
		addCompany.addcomponycountrydropdown();
		System.out.println("add dropdown in country in compony");
	}

	@Test(priority = 2)
	public void addComponyaction() {
		 CompanyPage addCompany = new CompanyPage();
		addCompany.addComponyaction();
		System.out.println("add compony in action class");
	}

	@AfterClass
	public void logout() {
		 LoginPage login1 = new LoginPage();
		login1.logout();
		System.out.println("logout successfully");

	}
}