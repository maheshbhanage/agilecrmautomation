package com.AgileCrmAutomation;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 extends BaseClass{
	@BeforeTest(groups = { "regression", "sanity" })
	public void add() {
		System.out.println("This is before test method");
		launchBrowser("chrome");
		driver.get("https://facebook.com");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("this is before method");
	}

	@Test(priority =1)
	public void test1() {
		
		System.out.println("thiss is test1  method");
	}

	@Test(priority = 2 )

	public void test2() {
		System.out.println("This is test2method");
		System.out.println(driver.getTitle());
		Assert.fail("test 2 failed");
	}

	@Test(dependsOnMethods="test2")

	public void test3() {
		System.out.println("this is test3  method");
	}

}
