package com.assingment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class AmazonElectronicsSearch extends BaseClass {
	 @Test(groups= {"regression"})
     @Parameters({"browser"})
	public void AmazonElectronics(String browser) {
		AmazonElectronicsSearch launch=new AmazonElectronicsSearch();
		launch.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		selectDropdownValByText(driver.findElement(By.id("searchDropdownBox")), "Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
		click(By.id("nav-search-submit-button"), "Click on search button");
		List<WebElement> laptopNames = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> laptopPrices = driver
				.findElements(By.xpath("//div[@class='sg-row']/descendant::span/span/span[@class='a-price-whole']"));

		for (int i = 0; i < laptopNames.size(); i++) {
			String name = laptopNames.get(i).getText();
			String price = laptopPrices.get(i).getText();
			String lprice = price.replace(",", "");

			Integer laptopprice = Integer.valueOf(lprice);
			if (laptopprice < 30000) {
				System.out.println(name + ":" + price);
			}
		}

	}

}