package com.pages.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPageObjects {
	@FindBy(how = How.CSS, using = "input#email")
	public WebElement userNameTxt;
	
	@FindBy(how = How.CSS, using = "input#password")
	public WebElement passwordTxt;
	
	@FindBy(how = How.CSS, using = "button#signInButton")
	public WebElement signInBtn;
	
	@FindBy(how = How.ID, using = "modal_window")
	public WebElement logInFrame;

}
