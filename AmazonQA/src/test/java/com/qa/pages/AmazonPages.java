package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPages {
	WebDriver Driver;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement gsearch;
	public WebElement Gsearch()
	{
		return gsearch;

	}
	
	@FindBy(xpath ="//div[@class='nav-search-scope nav-sprite']//select[1]")
	WebElement dropdown;
	public WebElement Dropdown() {
		return dropdown;
	}
	
	
	

	public AmazonPages(WebDriver Driver) {
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}

}