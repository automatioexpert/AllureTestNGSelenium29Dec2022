package allureReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static WebDriver driver;
	public static String url = "http://www.google.com";

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@Test(priority = 0)
	public void urlTest() {

		
		System.out.println(driver.getCurrentUrl());

	}

	@Test(priority = 1)
	public void titleTest() {

		System.out.println(driver.getTitle());

		Assert.fail("Failing this test deliberately");
	}

	@Test(priority = 2)
	public void skipTest() {

		throw new SkipException("Skipping this test");
		
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	}
