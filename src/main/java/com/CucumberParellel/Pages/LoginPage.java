package com.CucumberParellel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/main/div[2]/div/div/div/div[2]/div/form/div[1]/input") private WebElement emailTextBox ;
	@FindBy(name="password") private WebElement passwordTextbox ;
	@FindBy(xpath="//button[@class='btn btn-primary']") private WebElement loginButton;
	@FindBy(css="div#alert") private WebElement errorMessage ;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterEmail(String uname)
	{
		emailTextBox.sendKeys(uname);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public String showerrorMessage()
	{
		return errorMessage.getText();
	}

}
