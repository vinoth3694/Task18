package com.learning.selenium;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Jquery {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		// Launch a browser
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	driver.manage().deleteAllCookies();
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	@Test
	public void testSet() throws Exception {
		driver.get("https://jqueryui.com/droppable/"); // Launch the browser
		
		assertEquals(driver.getTitle(),"Droppable | jQuery UI"); 
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // Switching focus to inside frame
		
		WebElement drag = driver.findElement(By.id("draggable")); // Locating source element
		
		WebElement drop = driver.findElement(By.id("droppable")); // Locating target element
		
		// To implement mouse actions, we create object to Actions class
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform(); //implementing dragNdrop action
		
		String colorAfterDnD = drop.getCssValue("color");
		assertEquals(colorAfterDnD,"rgba(119, 118, 32, 1)"); // Verifying the color property of target element
		
		assertEquals(drop.getText(),"Dropped!"); //Verifying the text after dragNdrop action
		Thread.sleep(2000);
	}
}

