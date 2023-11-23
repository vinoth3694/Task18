package com.learning.selenium;




	import static org.testng.Assert.assertEquals;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Facebook {	

			WebDriver driver;
			@BeforeMethod
			public void setUp()
			{
				// Launch a browser
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
			}
			@AfterMethod
			public void closeBrowser()
			{
				driver.quit();
			}
			@Test
			public void testSet() throws Exception {
				
				driver.get("https://www.facebook.com/"); 
				
				assertEquals(driver.getTitle(),"Facebook – log in or sign up"); 
				
				WebElement newAccount = driver.findElement(By.linkText("Create new account")); 
				newAccount.click();
				
				Thread.sleep(2000);
				
				WebElement firstname =driver.findElement(By.name("firstname")); // Enter first name
				firstname.sendKeys("vinoth");
				
				WebElement lastname = driver.findElement(By.name("lastname")); // Enter Last Name
				lastname.sendKeys("N S");
				
				WebElement validemail = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")); // Enter valid email
				validemail.sendKeys("TestUser2365463@gmail.com");
				// //input[starts-with(@placeholder,'Mobile')]  
				
				Thread.sleep(1500);
				
				WebElement Reentermail = driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']"));
				Reentermail.sendKeys("TestUser2365463@gmail.com");
				
				WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']")); 
				password.sendKeys("Demo@123");
				
				Thread.sleep(2000);
				
				Select Daydd = new Select(driver.findElement(By.id("day"))); 
				Daydd.selectByValue("11");
				
				
				Select monthdd = new Select(driver.findElement(By.id("month"))); 
				monthdd.selectByValue("5");
				
				Select yeardd = new Select(driver.findElement(By.id("year"))); 
				yeardd.selectByVisibleText("1985");
				
				driver.findElement(By.xpath("//label[contains(.,'Male')]")).click(); 
				
				Thread.sleep(2000);
				
				driver.findElement(By.name("websubmit")).click();
				
				Thread.sleep(2000);
				
				 // Verify the name of account if successfully registered
				WebElement textname = driver.findElement(By.xpath("//span[contains(text(),'vinoth')]")); 
				assertEquals(textname.getText(),"vinoth");
				
				Thread.sleep(2000);
			}
	}



