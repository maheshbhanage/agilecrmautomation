package com.AgileCrmPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.AgileCrmAutomation.BaseClass;

public class DealPage extends BaseClass {
By dealmenu=(By.id("dealsmenu"));
By adddeal=(By.xpath("//button[contains(text(),'Add Deal')]"));
WebElement dealname=(driver.findElement(By.xpath("//form[@id='opportunityForm']/descendant::input[@id='name']")));
WebElement value=driver.findElement(By.xpath("//*[@id=\"opportunityForm\"]/descendant::input[@name='currency_conversion_value']"));
WebElement savebutton=(driver.findElement(By.xpath("//div[@id='deals-new-footer']/a")));
WebElement searchbutton=driver.findElement(By.xpath("//li[@id='calendarmenu']/preceding::button[3]"));
By allselect=(By.xpath("//a[text()='All']"));

	public void Adddeals(String name,String value) {
		click((this.dealmenu), "Clicked on deals menu");
		click(this.adddeal, "click on add DEAL");
		waitForVisiibilityOfElement(dealname);
		(dealname).sendKeys(name);
		(this.value).sendKeys(value);
		waitForVisiibilityOfElement(savebutton);
		savebutton.click();
	      searchbutton.click();
		click(By.xpath("//a[text()='All']"), "click on all");
		click(By.xpath("//a[text()='Deals']"), "click on deals");
		driver.findElement(By.id("searchText")).click();
		WebElement search = driver.findElement(By.id("searchText"));
		search.sendKeys(name);
		driver.findElement(By.xpath("//button[@id=\"search-results\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id='deal-search-model-list']/tr[1]")).click();
		driver.findElement(By.xpath("//div[@id='deal-detail-actions-dropdown']/descendant::a[7]")).click();
		waitForVisiibilityOfElement(driver.findElement(By.xpath("//*[@id='opportunityUpdateModal']/div[2]/div/div[2]")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select select = new Select(driver.findElement(By.id("pipeline_milestone")));
		select.selectByVisibleText("Won");
		driver.findElement(By.xpath("//a[@id='opportunity_archive']")).click();
	}

	public void changeDealsStatus(String srcstatus,String dststatus,String dealposition ) throws Exception
	{
		click(By.id("dealsmenu"), "Clicked on deals menu");
		driver.manage().window().maximize();
		//wait until the element to clickable
		waitForElementToBeClickable(By.xpath("//ul[@milestone='"+srcstatus+"']/li[1]"));
		//locate source element
		WebElement srcElement=driver.findElement(By.xpath("//ul[@milestone='"+srcstatus+"']/li[1]"));
		//get the name of source deal
		String dealsname=driver.findElement(By.xpath("//ul[@milestone='"+srcstatus+"']/li[1]/descendant::a[1]")).getText();
		//locate destination element
		WebElement dstElement=driver.findElement(By.xpath("//ul[@milestone='"+dststatus+"']/li["+dealposition+"]"));
        Actions action=new Actions(driver);
        //perform drag nad drop between source and destination element
        action.dragAndDrop(srcElement, dstElement).build().perform();
        System.out.println("changing the status of "+dealsname+" from "+srcstatus+" to "+dststatus);
        //get the name of dest deal
        WebElement dstDealName=driver.findElement(By.xpath("//ul[@milestone='"+dststatus+"']/li[1]/descendant::a[1]"));
		verifyDealsStatus(dststatus,dstDealName);
				} 	
	public void verifyDealsStatus(String expectedStatus,WebElement element) throws Exception
	{
		//wait until the dst element is clickable 
		waitForElementToBeClickable(element);
		//perform click operation
		element.click();
		//get the updated status of deal
		String actualStatus=driver.findElement(By.xpath("//div[@class=' text-muted deal-track text-xs']/span[1]")).getText();
		//compare the actual and expected deal status
		 if(actualStatus.equals(actualStatus))
		 {
			 System.out.println("Successfully performed drag and drop operation"); 
		 }
		 else
		 {
			 throw new Exception("Drag and drop did worked from source element");
		 }
	}}