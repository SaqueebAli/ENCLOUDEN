package com.enclouden.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {
	
	@FindBy(xpath="//div/a")
	private List<WebElement> towns;
	

	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getTown() {
		return towns;
	}

}
