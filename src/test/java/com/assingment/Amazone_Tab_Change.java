package com.assingment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class Amazone_Tab_Change extends BaseClass {
	 @Test(groups= {"regression"})
     @Parameters({"browser"})
	public void TabChange(String browser) throws AWTException, InterruptedException {
		Amazone_Tab_Change launch=new Amazone_Tab_Change();
		launch.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in/");
		WebElement image = driver.findElement(By.id("desktop-banner"));
		Actions action = new Actions(driver);
		action.contextClick(image).build().perform();
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent window id" + parentWindowId);

		Set<String> allwindowsIds = driver.getWindowHandles();
		for (String windowId : allwindowsIds) {
			if (!windowId.equals(parentWindowId)) {
				System.out.println("child window Id" + windowId);
				driver.switchTo().window(windowId);
				System.out.println(driver.getTitle());
				List<WebElement> productName = driver
						.findElements(By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']"));
				List<WebElement> pricetag = driver.findElements(By.xpath("//div[@class='BadgeAutomated-module__badgeOneLineContainer_yYupgq1lKxb5h3bfDqA-B']/div[1]"));

				for (int i = 0; i <= productName.size(); i++) {
					String productname = productName.get(i).getText();
					String productprice = pricetag.get(i).getText();

					System.out.println(productname + ":" + productprice);
				}

			}
		}
	}

}