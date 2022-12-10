package com.qa.testscripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.IOException;
import com.qa.pages.AmazonPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	AmazonPages Amazonp;
	WebDriver Driver;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void Setup(String Browser,String Url)throws IOException
	{

		if(Browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			Driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			Driver=new FirefoxDriver();
		}
		else  if(Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\rajku\\Desktop\\Virtusa\\msedgedriver.exe\\");
			Driver=new EdgeDriver();
		}

		Amazonp=new AmazonPages(Driver);
		Driver.manage().window().maximize();
		Driver.get(Url);

	}

	@AfterClass public void TearDown() throws InterruptedException {
		Thread.sleep(5000); Driver.close(); }
}