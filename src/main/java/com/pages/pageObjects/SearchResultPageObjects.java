package com.pages.pageObjects;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPageObjects {
	
	@FindBy(how = How.CSS, using = "th#BaggageBundlingTemplate")
	public List <WebElement> oneWayPriceTexts;
	
	@FindBy(how = How.XPATH, using = "(//ul[contains(@class,'listView')])[2]//span[@class='INR']/..")
	public List <WebElement> roundTripDepartPriceTexts;
	
	@FindBy(how = How.XPATH, using = "(//ul[contains(@class,'listView')])[3]//span[@class='INR']/..")
	public List <WebElement> roundTripReturnPriceTexts;
	
	@FindBy(how = How.CSS, using = "button.booking")
	public List <WebElement> bookingBtn;
	
	@FindBy(how = How.CSS, using = "button.booking")
	public  WebElement bookingButtons;
	
	@FindBy(how = How.CSS, using = "input#insurance_confirm[name='insuranceConfirm']")
	public WebElement insuranceConfirmCheckBox;
	
	@FindBy(how = How.CSS, using = "input#itineraryBtn")
	public WebElement continueBookingBtn;
	
	@FindBy(how = How.XPATH, using = "(//button[text()='Book'])[3]")
	public WebElement multyCityBookingBtn;
	
	@FindBy(how = How.XPATH, using = "(//button[text()='Book'])[2]")
	public WebElement roundTripBookingBtn;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Your email address']")
	public WebElement yourEmailAdrsTextLabel;
	
	@FindBy(how = How.XPATH, using = "//li[@class='allFlights']")
	public WebElement allFlightTxtLabel;
	
	@FindBy(how = How.XPATH, using = "(//button[contains(@class,'selectAddonButton')])[1]")
	public WebElement addBaggageBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Done']")
	public WebElement addBaggageDoneBtn;
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'addonListName')]")
	public List<WebElement> addBaggageItem;
	
	
	
	
	public void clik(List <WebElement> bookingBtn) {
		
		for(WebElement ele:bookingBtn)
		{
			ele.click();
		}
	}
	
}
