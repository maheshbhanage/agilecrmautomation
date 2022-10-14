package com.assingment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonApplianceSearch extends BaseClass {
      @Test(groups= {"regression"})
      @Parameters({"browser"})
	public void AmazoneAppliances(String browser){
		AmazonApplianceSearch launch=new AmazonApplianceSearch();
		launch.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in");
		selectDropdownValByText(driver.findElement(By.id("searchDropdownBox")), "Appliances");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
		click(By.id("nav-search-submit-button"), "Click on search button");
		List<WebElement> appliancesNames = driver
				.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> appliancePrices = driver
				.findElements(By.xpath("//div[@class='sg-row']/descendant::span/span/span[@class='a-price-whole']"));

		for (int i = 0; i < appliancesNames.size(); i++) {
			String name = appliancesNames.get(i).getText();
			String price = appliancePrices.get(i).getText();
			System.out.println(name + ":" + price);
		}

	}

}