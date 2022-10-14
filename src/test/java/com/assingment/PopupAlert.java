package com.assingment;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.AgileCrmAutomation.BaseClass;

public class PopupAlert extends BaseClass {
	 @Test(groups= {"regression"})
     @Parameters({"browser"})
	public void informationalert(String browser) {
		PopupAlert alert=new PopupAlert();
		alert.launchBrowser(browser);
		driver.navigate().to("https://www.amazon.in");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("alert('This is sample alert!');");
       // driver.switchTo().alert().accept();
	}
  @Test
	public void alertConfirmation() {
		PopupAlert alert=new PopupAlert();
		alert.launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("confirm('This is sample alert!');");
      //  driver.switchTo().alert().accept();
	}
    @Test
	
	public void alertprompt() {
		PopupAlert alert=new PopupAlert();
		alert.launchBrowser("chrome");
		
		driver.navigate().to("https://www.amazon.in");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("prompt('This is sample alert!');");
     //  driver.switchTo().alert().accept();
	}


}
