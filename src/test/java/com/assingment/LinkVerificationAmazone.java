package com.assingment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class LinkVerificationAmazone extends BaseClass {
	 @Test(groups= {"regression"})
     @Parameters({"browser"})
	public void Linkverification(String browser) {
		LinkVerificationAmazone link1 = new LinkVerificationAmazone();
		link1.launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for (WebElement e : elements) {
			String link = e.getAttribute("href");
			{
				if (link != null && link.startsWith("http")) {
					System.out.println(link);
				}
			}

		}
	}
}