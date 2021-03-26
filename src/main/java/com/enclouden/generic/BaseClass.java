package com.enclouden.generic;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		log.info("Successfully set driver path");
	}
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() throws IOException {
		FileLib fl=new FileLib();
		String url=fl.getPropertyValue("URL");
		log.info("Successfully fetched data from property file");
		ChromeOptions ch= new ChromeOptions();
		ch.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		ch.addArguments("start-maximized");
		driver=new ChromeDriver(ch);
		log.info("Successfully invoked browser");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
//		driver.close();//Requirement says not to close the Windows/tabs
	}
}