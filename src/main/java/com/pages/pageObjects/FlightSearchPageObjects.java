package com.pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class FlightSearchPageObjects {

	@FindBy(how = How.XPATH, using = "//span[text()='Your trips']")
	public WebElement yourTripsTab;
	
	@FindBy(how = How.CSS, using = "input#SignIn")
	public WebElement signInBtn;
	
	@FindBy(how = How.XPATH, using = "//form[@id='SearchForm']/h1")
	public WebElement searchFlightTxt;
	
	@FindBy(how = How.ID, using = "OneWay")
	public WebElement oneWayRadioBtn;
	
	@FindBy(how = How.ID, using = "RoundTrip")
	public WebElement roundTripRadioBtn;
	
	@FindBy(how = How.ID, using = "MultiCity")
	public WebElement multiCityRadioBtn;
	
	@FindBy(how = How.ID, using = "FromTag")
	public WebElement fromTxtBox;
	
	@FindBy(how = How.ID, using = "ToTag")
	public WebElement toTxtBox;
	
	@FindBy(how = How.ID, using = "DepartDate")
	public WebElement departDateTxtBox;
	
	@FindBy(how = How.CSS, using = "input#ReturnDate")
	public WebElement returnDateTxtBox;
	
	@FindBy(how = How.CSS, using = "select#Adults")
	public WebElement adultsSelectDropDown;
	
	@FindBy(how = How.ID, using = "Childrens")
	public WebElement childrensSelectDropDown;
	
	@FindBy(how = How.ID, using = "Infants")
	public WebElement infantsSelectDropDown;
	
	@FindBy(how = How.ID, using = "SearchBtn")
	public WebElement SearchBtn; 
	
	@FindBy(how = How.XPATH, using = "((//div[@class='ctDatePicker'])//a)[26]")
	public WebElement selectDepartureDate;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='ctDatePicker']//a)[63]")
	public WebElement selectReturnDate;
	
	@FindBy(how = How.ID, using = "modifySearchLink")
	public WebElement modifySearchLink;
	
	@FindBy(how = How.CSS, using = "input#FromTag1")
	public WebElement fromTxtBoxFirst;
	
	@FindBy(how = How.CSS, using = "input#ToTag1")
	public WebElement toTxtBoxFirst;
	
	@FindBy(how = How.CSS, using = "input#FromTag2")
	public WebElement fromTxtBoxSec;
	
	@FindBy(how = How.CSS, using = "input#ToTag2")
	public WebElement toTxtBoxSec;
	
	@FindBy(how = How.CSS, using = "input#FromTag3")
	public WebElement fromTxtBoxThird;
	
	@FindBy(how = How.CSS, using = "input#ToTag3")
	public WebElement toTxtBoxThird;
	
	@FindBy(how = How.CSS, using = "input#DepartDate1")
	public WebElement departDateTxtBoxOne;
	
	@FindBy(how = How.CSS, using = "input#DepartDate2")
	public WebElement departDateTxtBoxTwo;
	
	@FindBy(how = How.CSS, using = "input#DepartDate3")
	public WebElement departDateTxtBoxThree;
	
}
