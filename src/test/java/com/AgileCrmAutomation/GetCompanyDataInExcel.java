package com.AgileCrmAutomation;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AgileCrmPages.LoginPage;

public class GetCompanyDataInExcel extends BaseClass{
	
		public void searchContact() throws FileNotFoundException {
			String sheetname="GetContact12";
			GetCompanyDataInExcel get=new GetCompanyDataInExcel();
			get.launchBrowser("chrome");
			driver.navigate().to("https://rolex.agilecrm.com");
			LoginPage loginuser = new LoginPage();
			System.out.println(" Testcase1- username and valid password");
			loginuser.login("mahesh33@yopmail.com","Test1234");
			 waitForVisiibilityOfElement(driver.findElement(By.xpath("//li[@id='companiesmenu']")));
			 click(By.xpath("//li[@id='companiesmenu']"),"click on compony menu");
			 waitForElementToBePresent(By.xpath("//a[@class='text-cap ']"));
			 List<WebElement>companylist = driver.findElements(By.xpath("//a[@class='text-cap ']"));
			 List<WebElement>Owner = driver.findElements(By.xpath("//div[@style='width:12em;']"));
			 List<WebElement> date = driver.findElements(By.xpath("//div[@style='width:8em;']"));
				 for (int i=1; i<companylist.size(); i++) {
					String text=companylist.get(i).getText();
					String text1=Owner.get(i).getText();
					String text2=date.get(i).getText();
					System.out.println(text);
					System.out.println(text1);
					System.out.println(text2);
				ExelUtil getExel=new ExelUtil();
				getExel.setDataInExcel("C:\\Users\\Admin\\LoginTestData.xlsx",sheetname, i, 0,text);
				getExel.setDataInExcel("C:\\Users\\Admin\\LoginTestData.xlsx",sheetname, i, 1,text1);
				getExel.setDataInExcel("C:\\Users\\Admin\\LoginTestData.xlsx",sheetname, i, 2,text2);
			}
				 }
		
		public static void main(String[] args) throws FileNotFoundException
		{
			GetCompanyDataInExcel get=new GetCompanyDataInExcel();
			get.searchContact();
		}
		}

