package com.flipkart.HeaderTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.Base.TestBase;
import com.flipkart.Pages.HeaderPage;
import com.flipkart.Pages.ProductListingPage;
import com.flipkart.Utils.Actions;
import com.flipkart.Utils.FileUtils;

public class SearchProductTest extends Actions{

	@BeforeSuite
	public void setUP() throws IOException{
		TestBase.initFiles();
		Actions.openBrowser();
		 Actions.navigateTo(CONFIG.getProperty("TestURL"));
	}
	

	@Test(description="Verify the search products test on flipkart home page - header section")
	public void searchProductTest(){
		HeaderPage hp= PageFactory.initElements(driver, HeaderPage.class);
		hp.searchProduct("moto g3");
		
		ProductListingPage pp= PageFactory.initElements(driver, ProductListingPage.class);
		
		boolean isSearchTextPresent = pp.isElementPresent(pp.searchedTxt);

		boolean isProductTextCorrect=pp.verifySearchProduct("moto g3");
		
		Assert.assertTrue(isSearchTextPresent, "Search page for moto g3 was not displayed");
		Assert.assertTrue(isProductTextCorrect, "The search text is displayed incorrectly on Product listing page");
		
	}
	
	
	
	@Test(dataProvider="getSearchData",description="Verify the search products test on flipkart home page - header section - this tim eread data sets from the excel sheet")
	public void searchProductTest_dataDriven(String ProductName, String expectedTxt){
		HeaderPage hp= PageFactory.initElements(driver, HeaderPage.class);
		hp.searchProduct(ProductName);
		
		ProductListingPage pp= PageFactory.initElements(driver, ProductListingPage.class);
		
		boolean isSearchTextPresent = pp.isElementPresent(pp.searchedTxt);

		boolean isProductTextCorrect=pp.verifySearchProduct(expectedTxt);
		
		Assert.assertTrue(isSearchTextPresent, "Search page for moto g3 was not displayed");
		Assert.assertTrue(isProductTextCorrect, "The search text is displayed incorrectly on Product listing page");
		
	}
	
	
	@DataProvider
	public Object[][] getSearchData(){
		return FileUtils.getData(PROJECT_PATH+"\\src\\test\\resources\\headerTest\\HeaderTests.xlsx", "SearchProduct");
	}
	
	
	
	
	
	

}
