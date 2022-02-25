package com.Log4j.logs;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogsTest {
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	static WebDriver driver;
	
   Logger logger = LogManager.getLogger(LogsTest.class);
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prakash\\eclipse-workspace\\GenerateLogs\\chromedriver.exe");
		driver = new ChromeDriver();
		
		logger.info("launching Chrome Browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/");
		
		logger.trace("This is trace message");
		logger.info("entering application URL");
		logger.warn("This is warning message.....");
		logger.fatal("Hey this is just fatal error message.....");
		logger.debug("this is just debug message.....");
		logger.error("Hey this is error message.....");
		
	}
	
	
	@Test
	public void GoogleTitleTest() {
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Google");
	
	}
	
	@Test
	public void Googlelogotest() {
	boolean Logo = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		Assert.assertTrue(Logo, "Image is Displayed");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
