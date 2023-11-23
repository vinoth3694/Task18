package com.learning.selenium;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	
	public static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 driver.get("https://the-internet.herokuapp.com/upload");
		 
		 driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Admin\\Pictures\\Screenshots\\Selen.png");
		 
		 
		 driver.findElement(By.id("file-submit")).click();
		 
		 Thread.sleep(3000);

		 if(driver.getPageSource().contains("File Uploaded!"))
		 {
			 System.out.println("Successfully uploaded the file");
		 }
		 else
		 {
			 System.out.println("File upload failed");
		 }
		 
		 
		 
	}

}


