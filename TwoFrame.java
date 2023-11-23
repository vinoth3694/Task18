package com.learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		
		WebElement frame1Element=driver.findElement(By.tagName("body"));
		String frame1Text=frame1Element.getText();
		System.out.println("Frame1 is :"+frame1Text);
		
		driver.switchTo().frame(0);
		WebElement frame2Element=driver.findElement(By.tagName("p"));
		String frame2Text=frame2Element.getText();
		System.out.println("Frame2 is:" +frame2Text);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		WebElement mainPageText=driver.findElement(By.xpath("//div[@id='framesWrapper']"));
		System.out.println(mainPageText.getText());
		Thread.sleep(2000);
		driver.close();
		

	}

}
