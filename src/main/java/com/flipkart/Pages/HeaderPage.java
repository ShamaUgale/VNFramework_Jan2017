package com.flipkart.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Utils.Actions;

public class HeaderPage extends Actions{

	
	@FindBy(name="q")
	WebElement searchTextBox;
	//WebElement searchTextBox=driver.findElement(By.name("q"));
	
	@FindBy(xpath="//button[@type='submit' and @class='vh79eN']")
	WebElement searchBtn;

	public void searchProduct(String Product){
		type(searchTextBox, Product);
		click(searchBtn);
	}
	
}
