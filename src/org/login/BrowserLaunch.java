package org.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BrowserLaunch {
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\newEclipseWorkspe\\SampleSelenium\\Driver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		// Launching the browser
		WebDriver driver = new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement popupCloseBtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		popupCloseBtn.click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Iphone 14pro max");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
		
		//Switch the Control from the parent tab to the Child tab
		//get the parent tab iD
		String parId = driver.getWindowHandle();
		
		//get all the ids
		Set<String> allIds = driver.getWindowHandles();
		
		//Iterate the Set
		//a(p, c)
		for (String a : allIds) {
			//Compare the parent Id and child id
			if(!parId.equals(a)) {
				driver.switchTo().window(a);
				WebElement textElement = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
				String text = textElement.getText();
				System.out.println(text);
				
			}
		}
		
		driver.switchTo().window(parId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]")).click();
		
		
		
		
		
		
		}
		
		
	}


