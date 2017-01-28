package com.flipkart.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.flipkart.Base.TestBase;

public class Actions extends TestBase{

	static WebDriver driver= new TestBase().driver;
	
	public static void openBrowser(){
		
		
		
		String browser= CONFIG.getProperty("Browser");
		String firefoxProfile= CONFIG.getProperty("FirefoxProfile");
		int implicitWait= Integer.parseInt((CONFIG.getProperty("implicitwait")));
		
		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setBrowserName(browser);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
		caps.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", PROJECT_PATH+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver= new ChromeDriver(caps);
		}else if(browser.equalsIgnoreCase("FF")){
			
			if(firefoxProfile.equalsIgnoreCase("NA")){
				driver= new FirefoxDriver(caps);
			}else{
				ProfilesIni fp= new ProfilesIni();
				FirefoxProfile profile=fp.getProfile(firefoxProfile);
				driver= new FirefoxDriver(profile);
			}
		}else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", PROJECT_PATH+"\\src\\main\\resources\\drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver(caps);
		}else{
			System.setProperty("webdriver.chrome.driver", PROJECT_PATH+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver= new ChromeDriver(caps);
		}
		
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
	}
	
	public static  void navigateTo(String URL){
		driver.navigate().to(URL);
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public void navigateForward(){
		driver.navigate().forward();
	}
	
	public void refreshPage(){
		driver.navigate().refresh();
	}
	
	public void click(WebElement elem){
		elem.click();
	}
	
	public void type(WebElement elem, String data){
		elem.clear();
		elem.sendKeys(data);
	}
	
	public void checkCheckBox(WebElement elem){
		if(! elem.isSelected()){
			elem.click();
		}
	}
	
	public void uncheckCheckBox(WebElement elem){
		if( elem.isSelected()){
			elem.click();
		}
	}
	
	
	public String getText(WebElement elem){
		return elem.getText();
	}
	
	public boolean verifyText(WebElement elem, String expectedText){
		String actualText= elem.getText();
		if(actualText.equalsIgnoreCase(expectedText)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isElementPresent(WebElement elem){
		return elem.isDisplayed();
	}
	
	// verifyChechBoxIschecked
	//verifyChechBoxIsunchecked
	//verifyRadioSelected
	//verifyRadioNotSelected
	//selectByIndex
	//SelectByValueAttribute
	//SelecteByText
	//getDropDownOptionsCount
	//getAllDropDownOptions
	//getSelectedTextInDropDown
	//verifySelectedTextInDropDown
	
	
	
	
	
	
	
	
}
