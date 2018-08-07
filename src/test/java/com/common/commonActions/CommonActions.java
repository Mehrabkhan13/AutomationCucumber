package com.common.commonActions;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonActions {
	public static WebDriver driver;
	Properties properties;

	public void launchBrowser(String browser) throws Exception{
		if(browser.equalsIgnoreCase("FIREFOX")){
			System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			String url=getData("URL");
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			String url=getData("URL");
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			String url=getData("URL");
			driver.get(url);
		}
		else{

			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void launchBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url=getData("URL");
		driver.get(url);
	}

	public void loadDataData() throws IOException {
		properties=new Properties();

		File f=new File(System.getProperty("user.dir")+"\\config\\Config.properties");

		FileReader obj =new FileReader(f);

		properties.load(obj);
	}

	public String getData(String data) throws IOException {
		loadDataData();
		String reqData=properties.getProperty(data);
		return reqData;
	}
	public void enterText(WebElement element,String text){
		try
		{
			element.sendKeys(text);

		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
	}

	public void click(WebElement element){
		try
		{
			element.click();
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
	}

	public void clearTextBox(WebElement element){
		try
		{
			element.clear();
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
	}

	public String getText(WebElement element){
		try
		{
			element.getText();
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
		return element.getText();
	}

	public void selectFromDropDown1(WebElement element,String text){
		try
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
	}
	
	public void selectFromDropDown(WebElement element,String text){
		try {
		     Select select=new Select(element);
		     select.getOptions().stream().anyMatch(item->item.getText().equals(text));
		     select.selectByVisibleText(text);
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
	}

	public void switchToFrame(String frameName) throws InterruptedException{
		try
		{
			waitForElement();

			driver.switchTo().frame(frameName);
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}
	}

	public  void waitForElement() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}

	public void closeBrowser()
	{
		driver.close();
	}

	public void assertEquals(String actual, String expected) {
		// TODO Auto-generated method stub

		Assert.assertEquals(actual, expected);
	}

	public void waitForPageLoad(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);

			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();	
		}

	}
	
	public void selectOneWayMinPrice(List <WebElement> element,List <WebElement> bookElement) {

		ListIterator<WebElement> li=element.listIterator();

		ArrayList<Integer> prices=new ArrayList<Integer>();
		
		List <WebElement> priceTexts=element;

		while(li.hasNext()){

			WebElement element1= li.next();

			String price1=element1.getText().replaceAll("[^0-9]", "");

			Integer price=Integer.valueOf(price1);

			prices.add(price);
		}
		
		List<Integer> slist = prices.stream().sorted().collect(Collectors.toList());
		
		int smallest=slist.get(0);
		
	    String smallestPrice=String.valueOf(smallest);
	    
	    //String c=x -> x.getText().replaceAll("[^0-9,]", "");
	    
	    priceTexts.stream().filter(x -> x.getText().replaceAll("[^0-9,]","").contains(smallestPrice)).findFirst().ifPresent(ele -> ele.click());
	
    	for(int price:prices)
		{   
			int i=prices.indexOf(price);
			if(price==smallest)
			{
				driver.findElement(By.xpath("(//table[contains(@class,'flightDetailsLink')])["+(i+1)+"]//button[@class='booking']")).click();
				break;
			}
		}
	}

	public void selectOneWayMinPrice1(List <WebElement> element,List <WebElement> bookingBtnElement ) {

		ListIterator<WebElement> li=element.listIterator();
		
		ArrayList<Integer> prices=new ArrayList<Integer>();
		
		//List <WebElement> bookBtn=bookingBtnElement;

		int smallest = Integer.MAX_VALUE;

		while(li.hasNext()){

			WebElement element1= li.next();

			String price1=element1.getText().replaceAll("[^0-9]", "");

			Integer price=Integer.valueOf(price1);

			prices.add(price);
		}
		
		prices.stream().sorted().forEach(value->System.out.println(prices));

		for(Integer a:prices ) {

			if(smallest > a ) {

				smallest = a;
			}
		}
		
		System.out.println("Smallest number in array is : " +smallest);	
		for(int price2:prices)
		{   
			int i=prices.indexOf(price2);
			if(price2==smallest)
			{
				driver.findElement(By.xpath("(//table[contains(@class,'flightDetailsLink')])["+(i+1)+"]//button[@class='booking']")).click();
				break;
			}
		}
		
		//bookBtn.stream().filter(price -> price.getText().contains(smallest)).findFirst().ifPresent(ele -> ele.click()); 
	}

	public void selectRoundTripDepartMinPrice(List <WebElement> element) {

		ListIterator<WebElement> li=element.listIterator();

		ArrayList<Integer> prices=new ArrayList<Integer>();

		while(li.hasNext()){

			WebElement element1= li.next();

			String price1=element1.getText().replaceAll("[^0-9]", "");

			Integer price=Integer.valueOf(price1);

			prices.add(price);
		}
		List<Integer> slist = prices.stream().sorted().collect(Collectors.toList());
		
		int smallest=slist.get(0);
	
		for(int price2:prices)
		{   
			int i=prices.indexOf(price2);
			if(price2==smallest)
			{
				driver.findElement(By.xpath("((//ul[contains(@class,'listView')])[2]//input[@type='radio']["+(i+1)+"])")).click();
				break;
			}
		}
	}

	public void selectRoundTripReturnMinPrice(List <WebElement> element) {

		/*		List<WebElement> excessBaggageList = driver.findElements(By.xpath(".//li[@class='relative']/a/span[1]"));

		excessBaggageList.stream().filter(x -> x.getText().contains(value)).findFirst().ifPresent(ele -> ele.click());*/

		ListIterator<WebElement> li=element.listIterator();

		ArrayList<Integer> prices=new ArrayList<Integer>();

		while(li.hasNext()){

			WebElement element1= li.next();

			String price1=element1.getText().replaceAll("[^0-9]", "");

			Integer price=Integer.valueOf(price1);

			prices.add(price);
		}

		List<Integer> slist = prices.stream().sorted().collect(Collectors.toList());
		
		int smallest=slist.get(0);
		
		for(int price:prices)
		{   
			int i=prices.indexOf(price);
			if(price==smallest)
			{
				driver.findElement(By.xpath("((//ul[contains(@class,'listView')])[3]//input[@type='radio']["+(i+1)+"])")).click();
				break;
			}
		}
	}
	
	public void addLuggage(WebElement addBaggageBtnElement,String frameName,List<WebElement> element,WebElement addBaggageDoneBtnElement) throws InterruptedException {
		
		waitForPageLoad(addBaggageBtnElement);
		
		click(addBaggageBtnElement);
		
		switchToFrame(frameName);
		
		waitForElement();
		
	    List<WebElement> excessBaggageList = element;
		
		excessBaggageList.stream().filter(y -> y.getText().contains("5")).findFirst().ifPresent(ele -> ele.click()); 
		
		click(addBaggageDoneBtnElement);
	}
}
