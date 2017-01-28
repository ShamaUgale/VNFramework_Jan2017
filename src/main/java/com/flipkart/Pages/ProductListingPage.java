package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Utils.Actions;

public class ProductListingPage extends Actions {

	
	
	@FindBy(xpath="//span[@class='W-gt5y']")
	public WebElement searchedTxt;
	
	
	public boolean verifySearchProduct(String Product){
		return verifyText(searchedTxt, Product);
	}
	
}
