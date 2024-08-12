package com.paytm.WebdriverUtils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	WebDriver driver;

	public void waitForPageToLoad() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void maximizePage() {
		driver.manage().window().maximize();
	}

	public void selectByIndex(WebElement ele, int no) {
		Select s = new Select(ele);
		s.selectByIndex(no);

	}
	
	public void selectByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);

	}
	
	public void selectByVisibleText(WebElement ele,String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);

	}
	
	public void moveToElements(WebElement element) {
		Actions act = new  Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void dragdrop( WebElement drag, WebElement drop) {
		Actions act = new  Actions(driver);
		act.dragAndDrop(drag,drop).perform();
	}
	
	public void contextClickmethod(WebElement element) {
		Actions act = new  Actions(driver);
		act.contextClick(element).perform(); 
	}
	
	public void switchFrame(int no) {
		driver.switchTo().frame(no);
	}
	
	public void switchWindowWithUrl(CharSequence url) {
		Set<String> whandle = driver.getWindowHandles();
		Iterator<String> itr=whandle.iterator();
		while(itr.hasNext())
		{
			
			String wid = itr.next();
			driver.switchTo().window(wid);
			String actStr = driver.getCurrentUrl();
			if (actStr.contains(url)) {
				break;
			}
		}
	}
			
			
		
}
