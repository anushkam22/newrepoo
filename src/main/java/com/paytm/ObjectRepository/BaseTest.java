package com.paytm.ObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.paytm.DbUtils.DbConnection;
import com.paytm.ExcelUtils.ExcelUtils;
import com.paytm.FileUtils.FileUtils;
import com.paytm.JavaUtils.JavaUtils;
import com.paytm.WebdriverUtils.WebDriverUtils;



public class BaseTest {

	public WebDriver driver = null;
	public FileUtils flib = new FileUtils();
	public ExcelUtils elib = new ExcelUtils();
	public JavaUtils jlib = new JavaUtils();
	public WebDriverUtils wlib = new WebDriverUtils();
	public DbConnection dlib = new DbConnection();
	public static WebDriver sdriver = null;

//	@BeforeSuite(groups = "ST")
//	public void configBS() throws Throwable {
//		dlib.getConnection(null, null, null);
//
//	}

	@BeforeClass()
	public void launchBrowser() throws Throwable {

		String browser = flib.getDataFromPropertyFile("browser");
		String url = flib.getDataFromPropertyFile("url");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		wlib.maximizePage();
		wlib.waitForPageToLoad();
		driver.get(url);
	}

	@BeforeMethod()
	public void loginIntoSS() throws Throwable {
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
//		WelcomePage wp = new WelcomePage(driver);
//		wp.getSignbtn().click();
//
//		LoginPage slp = new LoginPage(driver);
//		slp.login(username, password);
//		System.out.println("enter");
	}

//	@AfterMethod()
//	public void logoutSS() {
//		HomePage hp = new HomePage(driver);
//		hp.clickOnLogout();
//
//	}

//	@AfterClass()
//	public void closeBrowser() {
//		driver.quit();
//	}

//	@AfterSuite(groups = "ST")
//	public void ConfigAs() throws Throwable {
//		dlib.closeConnection();
//		// report.flush();
//	}

}
