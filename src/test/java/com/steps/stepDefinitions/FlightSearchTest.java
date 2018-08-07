package com.steps.stepDefinitions;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.common.commonActions.CommonActions;
import com.excel.utility.ExcelUtils;
import com.pages.pageObjects.FlightSearchPageObjects;
import com.pages.pageObjects.LogInPageObjects;
import com.pages.pageObjects.SearchResultPageObjects;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightSearchTest extends CommonActions{
	CommonActions commonActions;
	FlightSearchPageObjects searchFlightPageObjects;
	LogInPageObjects logInPageObjects;
	SearchResultPageObjects searchResultPageObjects;
	ExcelUtils excelUtils;
	@Before
	public void setUpEnv() throws InvalidFormatException, IOException,Exception {
		commonActions=new CommonActions();
		
		commonActions.launchBrowser(getData("BROWSER"));
		
		searchFlightPageObjects=PageFactory.initElements(driver, FlightSearchPageObjects.class);
		
		logInPageObjects=PageFactory.initElements(driver, LogInPageObjects.class);
		
		searchResultPageObjects=PageFactory.initElements(driver, SearchResultPageObjects.class);
		
		excelUtils=new ExcelUtils(getData("TESTDATA_PATH"));
		
	}

	@Given("Navigated to flight search page for one way search.")
	public void flightSearchPage(){
		
		String actual=getText(searchFlightPageObjects.searchFlightTxt);
		
		Assert.assertEquals(actual,"Search flights");
	}

	@When("Enter the search deatils for one way.")
	public void oneWaySearch() throws Exception {
		commonActions.click(searchFlightPageObjects.oneWayRadioBtn);
		
		commonActions.enterText(searchFlightPageObjects.fromTxtBox,excelUtils.getCellData(1, 2));
		
		commonActions.enterText(searchFlightPageObjects.toTxtBox,excelUtils.getCellData(1, 3));
		
		commonActions.click(searchFlightPageObjects.departDateTxtBox);
		
		commonActions.click(searchFlightPageObjects.selectDepartureDate);
		
		//commonActions.selectFromDropDown(searchFlightPageObjects.adultsSelectDropDown,excelUtils.getCellData(1, 6));
		
		commonActions.selectFromDropDown(searchFlightPageObjects.childrensSelectDropDown,excelUtils.getCellData(1, 7));
		
		commonActions.selectFromDropDown(searchFlightPageObjects.infantsSelectDropDown,excelUtils.getCellData(1, 8));
		
		commonActions.click(searchFlightPageObjects.SearchBtn);
		
		//commonActions.waitForElement();
		
		waitForPageLoad(searchResultPageObjects.allFlightTxtLabel);
		
		commonActions.selectOneWayMinPrice1(searchResultPageObjects.oneWayPriceTexts,searchResultPageObjects.bookingBtn);

		commonActions.addLuggage(searchResultPageObjects.addBaggageBtn,"modal_window",searchResultPageObjects.addBaggageItem,
				searchResultPageObjects.addBaggageDoneBtn);
			 
		commonActions.click(searchResultPageObjects.insuranceConfirmCheckBox);
		
		commonActions.click(searchResultPageObjects.continueBookingBtn);
		
		waitForPageLoad(searchResultPageObjects.yourEmailAdrsTextLabel);
	}

	@Then("Search result page is displayed for one.")
	public void searchResultDisplayed() {
		
		try {
			commonActions.waitForElement();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actual=getText(searchResultPageObjects.yourEmailAdrsTextLabel);
		
		Assert.assertEquals(actual,"Your email address");
	}
	
	@Given("Navigated to flight search page for round trip.")
	public void flightSearchPageRoundTrip(){
		String actual=getText(searchFlightPageObjects.searchFlightTxt);
		
		Assert.assertEquals(actual,"Search flights");

	}
	
	@When("Enter the search deatils for round trip.")
	public void roundTripSearch() throws Exception {
		commonActions.click(searchFlightPageObjects.roundTripRadioBtn);
		
		commonActions.enterText(searchFlightPageObjects.fromTxtBox,excelUtils.getCellData(1, 2));
		
		commonActions.enterText(searchFlightPageObjects.toTxtBox,excelUtils.getCellData(1, 3));
	
		commonActions.click(searchFlightPageObjects.departDateTxtBox);
		
		commonActions.click(searchFlightPageObjects.selectDepartureDate);
		
		commonActions.clearTextBox(searchFlightPageObjects.returnDateTxtBox);
		
		commonActions.enterText(searchFlightPageObjects.returnDateTxtBox,excelUtils.getCellData(1, 4));
		
		commonActions.click(searchFlightPageObjects.roundTripRadioBtn);
	
		commonActions.selectFromDropDown(searchFlightPageObjects.childrensSelectDropDown,excelUtils.getCellData(1, 7));
		
		commonActions.selectFromDropDown(searchFlightPageObjects.infantsSelectDropDown,excelUtils.getCellData(1, 8));
		
 		commonActions.click(searchFlightPageObjects.SearchBtn);
		
 		waitForPageLoad(searchResultPageObjects.allFlightTxtLabel);
		
/*		commonActions.selectRoundTripDepartMinPrice(searchResultPageObjects.roundTripDepartPriceTexts);
		
		commonActions.selectRoundTripReturnMinPrice(searchResultPageObjects.roundTripReturnPriceTexts);*/
		
		commonActions.click(searchResultPageObjects.roundTripBookingBtn);
		commonActions.waitForElement();
		
		commonActions.click(searchResultPageObjects.insuranceConfirmCheckBox);
		
		commonActions.waitForElement();
		
		commonActions.click(searchResultPageObjects.continueBookingBtn);
		
		waitForPageLoad(searchResultPageObjects.yourEmailAdrsTextLabel);
	}
	
	@Then("Search result page is displayed for round trip.")
	public void roundTripSearchResultDisplayed() throws InterruptedException {
		commonActions.waitForElement();
		
		String actual=getText(searchResultPageObjects.yourEmailAdrsTextLabel);
		
		Assert.assertEquals(actual,"Your email address");

	}
	
	
	@Given("Navigated to flight search page for multi city trip.")
	public void flightSearchPagemultiCity(){

	}
	
	@When("Enter the search deatils for multi city trip.")
	public void multiCitySearch() throws Exception {
		commonActions.click(searchFlightPageObjects.multiCityRadioBtn);
		
		commonActions.enterText(searchFlightPageObjects.fromTxtBoxFirst,excelUtils.getCellData(1, 2));
		
		commonActions.enterText(searchFlightPageObjects.toTxtBoxFirst,excelUtils.getCellData(1, 3));
		
		commonActions.enterText(searchFlightPageObjects.departDateTxtBoxOne,excelUtils.getCellData(1,4));
		
/*		commonActions.click(searchFlightPageObjects.departDateTxtBoxOne);
		
		commonActions.click(searchFlightPageObjects.selectDepartureDate);*/
		
		commonActions.clearTextBox(searchFlightPageObjects.fromTxtBoxSec);
		
		commonActions.enterText(searchFlightPageObjects.fromTxtBoxSec,excelUtils.getCellData(2, 2));
		
		commonActions.enterText(searchFlightPageObjects.toTxtBoxSec,excelUtils.getCellData(2, 3));
		
		commonActions.click(searchFlightPageObjects.departDateTxtBoxTwo);
		
		commonActions.click(searchFlightPageObjects.selectDepartureDate);
		
		commonActions.clearTextBox(searchFlightPageObjects.fromTxtBoxThird);
		
		commonActions.enterText(searchFlightPageObjects.fromTxtBoxThird,excelUtils.getCellData(3, 2));
		
		commonActions.enterText(searchFlightPageObjects.toTxtBoxThird,excelUtils.getCellData(3, 3));
		
		commonActions.click(searchFlightPageObjects.departDateTxtBoxThree);
		
		commonActions.click(searchFlightPageObjects.selectDepartureDate);
		
		commonActions.click(searchFlightPageObjects.SearchBtn);
		
		waitForPageLoad(searchResultPageObjects.allFlightTxtLabel);
		
		commonActions.click(searchResultPageObjects.multyCityBookingBtn);
		
		commonActions.waitForElement();
		
		commonActions.click(searchResultPageObjects.insuranceConfirmCheckBox);
		
		commonActions.waitForElement();
		
		commonActions.click(searchResultPageObjects.continueBookingBtn);
		
		waitForPageLoad(searchResultPageObjects.yourEmailAdrsTextLabel);
		
	}
	
	@Then("Search result page is displayed for multi city trip.")
	public void multiCitySearchResultDisplayed() throws InterruptedException {
		
		commonActions.waitForElement();
		
		String actual=getText(searchResultPageObjects.yourEmailAdrsTextLabel);
		
		Assert.assertEquals(actual,"Your email address");
	}
	
	public void searchDetails(WebElement fromElement,WebElement toElement,WebElement departDateElement,
			String fromCity,String toCity,String departDate) {
		commonActions.enterText(fromElement,fromCity);
		
		commonActions.enterText(toElement,toCity);
		
		commonActions.enterText(departDateElement,departDate);
	}
	
	
	@After
	public void tearDown() {
		commonActions.closeBrowser();
	}
}