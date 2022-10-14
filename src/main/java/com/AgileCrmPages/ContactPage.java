package com.AgileCrmPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.AgileCrmAutomation.BaseClass;

public class ContactPage extends BaseClass{
	
By contactmenu=By.xpath("//li[@id=\"contactsmenu\"]/a");
By addcontact=By.xpath("//*[@id=\"view-list\"]/div/button");
By fristname=By.id("fname");
WebElement lastname =driver.findElement(By.xpath("//input[@id='lname']"));
By continuebutton=By.xpath("//a[@id='continue-contact']");
WebElement emailid=driver.findElement(By.xpath("//div[@class='controls second col-sm-9']/div/div/input[@name='email']"));
By emaildroodown=By.name("//div[@class='email multiple-template']/div[2]/select");
By savebutton=By.xpath("//a[@id='update']");
By searchbutton=By.xpath("//*[@id=\"navbar\"]/ul[1]/li[1]/div/button");
By searchsymbol=By.xpath("//*[@id='advanced-search-fields-group']/li[1]/a/label/i");
WebElement allcontactbox=driver.findElement(By.xpath("//*[@id='advanced-search-fields-group']/li[1]/a/label/i"));
WebElement contactbox=driver.findElement(By.xpath("//*[@id=\'advanced-search-fields-group\']/li[2]/a/label/i"));
By searchtext=By.id("searchText");
WebElement search=driver.findElement(By.id("search-results"));
By newcontactid=(By.xpath("//TBODY[@CLASS='AGILE-EDIT-ROW']/DESCENDANT::IMG[1]"));
By optionbutton=By.xpath("//div[@class='contact-lhs-actions']/descendant::i[3]");
By deletebutton=By.xpath("//li/a[@id=\"contact-actions-delete\"]/span");
By deleleteconfirm=By.xpath("//*[@id=\"success_callback\"]");
By editbutton=By.xpath("//div[@class='contact-lhs-actions']/a/i[@class='material-icons edit']");
By upadatebutton=By.id("update");



	String firstName;
	String lastName;
	String emailId;
	String mobNum;
	
	public void addcontact(String firstname,String lastname)
	{
		 click(this.contactmenu,"click on contact menu");
		 click((this.addcontact),"click on add contact button");
		  fluentWait(this.fristname);
		 driver.findElement(this.fristname).sendKeys(firstName);
		this.lastname .sendKeys(lastname);
		 click(this.continuebutton,"click continue editing");
		this.emailid.sendKeys("mahesh@gmail.com");
		 fluentWait(this.emaildroodown);
			Select select = new Select(driver.findElement(emaildroodown));
			List<WebElement> emaildropdownlist = select.getOptions();
			for (WebElement element : emaildropdownlist) {
				String text = element.getAttribute("value");
				System.out.println(text);
				select.selectByValue("Work");
		 click(this.savebutton,"save on save button");
		 System.out.println("contact add successfully");
	    }}
	public void searchContact(String firstname)
	{
		fluentWait(this.contactmenu);
		 click(this.contactmenu,"click contact menu");
		 click(this.searchbutton,"click to search button");
		click(this.searchsymbol,"click to search symbol");
	if((this.allcontactbox).isSelected())//all contact option are  are selected then click on box 
	{
		this.allcontactbox.click();//click to contact box
	}
		else
		{
		this.contactbox.click();//click to contact
		}
	click(this.searchtext,"click to search button");
	driver.findElement(this.searchtext).sendKeys(firstname);
	System.out.println(firstName);
	this.search.click();	
	 System.out.println("contact search complete");
    }

	public void deletecontact()
	{
		click(this.contactmenu,"click on contact menu");
		 click(this.newcontactid, "click to contact");		
		click(this.optionbutton,"click on option button");
		 click(this.deletebutton, "click to delete");
		 click(this.deleleteconfirm,"click to confirm delete");
		 System.out.println("contact Delete successfully");
    }
	
	public void upadatecontact(String firstname)
	{
		click(this.contactmenu,"click on contact menu");
		 click((this.newcontactid), "click to contact");
		 click(this.editbutton, "click to edit button");
		 click(this.fristname, "click first name column");
		 driver.findElement(this.fristname).sendKeys(firstname);
		 System.out.println("enter frist name");
		 click(this.upadatebutton, "click to update contact");
		 System.out.println("contact upadate successfully");
	}
}