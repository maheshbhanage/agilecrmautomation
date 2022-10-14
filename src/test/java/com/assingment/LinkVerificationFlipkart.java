package com.assingment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class LinkVerificationFlipkart extends BaseClass {
	 @Test(groups= {"regression"})
     @Parameters({"browser"})
	public void flipkartverification(String browser) {

		LinkVerificationFlipkart launch = new LinkVerificationFlipkart();
		launch.launchBrowser(browser);
		driver.navigate().to("https://www.flipkart.com/");
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		for (WebElement e1 : elements) {
			String link = e1.getAttribute("src");
			if (link != null && link.startsWith("http")) {
				System.out.println(link);
			}

		}

	}
}