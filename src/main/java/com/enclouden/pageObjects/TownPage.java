package com.enclouden.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TownPage {

	@FindBy(xpath = "//tr[@style='color:Black;background-color:#DEDFDE;']/td[2]/span")
	private List<WebElement> saleDate;

	@FindBy(xpath = "//tr[@style='color:Black;background-color:#DEDFDE;']/td[5]/a")
	private List<WebElement> linksList;

	public TownPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public List<WebElement> getLinksList() {
		return linksList;
	}
	
	public List<WebElement> getSaleDateList(){
		return saleDate;
	}
	

}
