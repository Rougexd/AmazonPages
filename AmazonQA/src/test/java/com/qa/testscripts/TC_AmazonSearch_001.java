package com.qa.testscripts;


import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;
import com.qa.utility.ExcelUtility;
public class TC_AmazonSearch_001 extends Base{
	AmazonPages amzp;
	@DataProvider(name="Data")
	public String[][] getData() throws IOException {

		String xFile="C:\\Users\\rajku\\Desktop\\Virtusa\\AmazonQA\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
		String xSheet="Sheet1";

		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for(int i=1; i<=rowCount; i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;

	}
	@Test(dataProvider="Data")
	public void Search(String category,String itemname) throws InterruptedException
	{
		amzp=new AmazonPages(Driver);
		Select slct=new Select(amzp.Dropdown());
		slct.selectByVisibleText(category);
		amzp.Gsearch().sendKeys(itemname+Keys.ENTER);
		amzp.Gsearch().clear();
	}
}