package com.learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snapdeal {
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@class='accountBtn btn rippleWhite']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number/ Email']")).sendKeys("vinothvino716@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='checkUser']")).click();
		Thread.sleep(1000);
	}

}
