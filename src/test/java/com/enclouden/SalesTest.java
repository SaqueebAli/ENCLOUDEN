package com.enclouden;

import java.awt.AWTException;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.enclouden.generic.BaseClass;
import com.enclouden.generic.CommonLib;
import com.enclouden.pageObjects.LandingPage;
import com.enclouden.pageObjects.TownPage;
@Listeners(com.enclouden.generic.ListenerImplementation.class)
public class SalesTest extends BaseClass {
	public static Logger log=LogManager.getLogger(SalesTest.class.getName());
	@Test
	public void checkSales() throws AWTException {
		LandingPage lp = new LandingPage(driver);
		String main = driver.getWindowHandle();
		String[] townNames = { "Fairfield", "Milford", "Trumbull", "Norwalk", "Stamford", "Shelton" };
		Set<String> whs = new HashSet<String>();
		Set<String> removeHandles = new HashSet<String>();
		removeHandles.add(main);
		for (String townName : townNames) {
			for (WebElement townLink : lp.getTown()) {
				if (townName.equals(townLink.getText())) {
				Actions act = new Actions(driver);
				act.keyDown(Keys.SHIFT).click(townLink).keyUp(Keys.SHIFT).perform();
				log.debug("SuccessFully opened town in new Window");
				whs = driver.getWindowHandles();
				whs.removeAll(removeHandles);
				log.info("Successfully removed all window handles except for the recently opened town details window");
				for (String w : whs) {
					driver.switchTo().window(w);
					log.info("Successfully switched to town details window");
					
				}

				TownPage tp = new TownPage(driver);
				for (int i = 0; i < tp.getLinksList().size(); i++) {
					boolean flag=CommonLib.filterDate(tp.getSaleDateList().get(i).getText().split("\n")[0]);
					log.info("Successfully executed filterDate method of CommonLib class");
					if(flag) {
						log.info("Successfully filtered date"+tp.getSaleDateList().get(i).getText().split("\n")[0]);
						act.keyDown(Keys.CONTROL).click(tp.getLinksList().get(i)).keyUp(Keys.CONTROL).perform();
						log.debug("SuccessFully opened view full notice link in new Tab");
					}
				}


			}
			removeHandles.addAll(driver.getWindowHandles());
			driver.switchTo().window(main);
			log.info("Successfully switched to main window");
			
		}
	}

}}
