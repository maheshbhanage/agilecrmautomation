package com.AgileCrmPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.AgileCrmAutomation.BaseClass;

public class CompanyPage extends BaseClass {

	public void addcomponymaildropdown() {
		click(By.id("companiesmenu"), "click to company page");
		click(By.xpath("//button[contains(text(),' Add Company')]"), "click to add company page");
		click(By.id("company_name"), "enter first name");
		waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(By.id("company_name")).sendKeys("mahi123");
		click(By.id("continue-company"), "click to continue edit button");
		fluentWait(By.name("email-select"));
		Select select = new Select(driver.findElement(By.name("email-select")));
		List<WebElement> emaildropdownlist = select.getOptions();
		for (WebElement element : emaildropdownlist) {
			String text = element.getAttribute("value");
			System.out.println(text);
			select.selectByValue("primary");
		}
	}

	public void addcomponycountrydropdown() {
		click(By.id("companiesmenu"), "click to company page");
		click(By.xpath("//button[contains(text(),' Add Company')]"), "click to add compony page");
		click(By.id("company_name"), "enter first name");
		waitForElementToBeClickable(By.id("company_name"));
		driver.findElement(By.id("company_name")).sendKeys("company");
		click(By.id("continue-company"), "click to continue edit button");
		fluentWait(By.id("country"));
		Select select = new Select(driver.findElement(By.id("country")));
		List<WebElement> countrydropdownlist = select.getOptions();
		for (WebElement element : countrydropdownlist) {
			String text = element.getText();
			System.out.println(text);
			select.selectByVisibleText("Primary");
		}
	}
	public void addComponyaction() {
		click(By.id("companiesmenu"), "click to company page");
		WebElement addComponyButton = driver.findElement(By.xpath("//button[contains(text(),' Add Company')]"));
		Actions action = new Actions(driver);// object of action class
		action.click(addComponyButton).build().perform();
		waitForElementToBeClickable(driver.findElement(By.id("company_name")));
		WebElement fristname = driver.findElement(By.id("company_name"));
		action.sendKeys("Ak127").click(fristname).build().perform();
		WebElement continueediting = driver.findElement(By.xpath("//a[@id='continue-company']"));
		action.click(continueediting).build().perform();
		waitForElementToBeClickable(driver.findElement(
				By.xpath("//div[@class='controls col-sm-9 second']/descendant::select[@name='email-select']")));
		Select select = new Select(driver.findElement(
				By.xpath("//div[@class='controls col-sm-9 second']/descendant::select[@name='email-select']")));
		select.selectByIndex(2);
		WebElement tag = driver
				.findElement(By.xpath("//div[@class='controls col-sm-9 company_input']/input[@id='tags-new-person']"));
		action.click(tag).sendKeys("Rolex").build().perform();

	}
}

