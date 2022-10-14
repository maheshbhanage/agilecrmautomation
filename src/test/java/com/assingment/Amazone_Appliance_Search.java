package com.assingment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class Amazone_Appliance_Search extends BaseClass {
	 @Test(groups= {"regression"})
     @Parameters({"browser"})
public void AppliancesSearch(String browser)throws AWTException
{
Amazone_Appliance_Search launch=new Amazone_Appliance_Search();
launch.launchBrowser(browser);
driver.navigate().to("https://www.amazon.in/");
WebElement customerService=driver.findElement(By.xpath("//div[@id='nav-xshop']/a[contains(text(),'Customer Service')]"));
Actions action=new Actions (driver); //right click on customer service link
action.contextClick(customerService).build().perform(); //select first option in right click pannel
Robot rb=new Robot();
rb.keyPress (KeyEvent.VK_DOWN);
rb.keyRelease(KeyEvent.VK_DOWN); rb.keyPress (KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
//get parent window id
String parentWindowId=driver.getWindowHandle(); 
System.out.println("Parent Window Id: "+parentWindowId);
 // get all window ids"
Set<String> allWindowIds= driver.getWindowHandles(); 
//iterate set of all window
for (String windowId: allWindowIds) 
{
	//if window id is not parent then go inside if condition
if(!windowId.equals(parentWindowId)) 
{
System.out.println("Child window id: " + windowId);
//switch to another windo
driver.switchTo().window(windowId);
//print the title of page
System.out.println(driver.getTitle());
}}
//switch back control to parent window
driver.switchTo().window(parentWindowId);
//driver.switchTo().defaultContent();
//print the title of parent window
System.out.println(driver.getTitle());
}}