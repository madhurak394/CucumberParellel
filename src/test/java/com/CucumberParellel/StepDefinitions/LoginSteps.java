package com.CucumberParellel.StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.CucumberParellel.Pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = new ChromeDriver();
	
	// Calling Login page
	
	LoginPage login=new LoginPage(driver);
	//LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
	/*@Before
	public void setup()
	{
		driver=new ChromeDriver();
	}
	*/
	
	@After()
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	@Given("I am on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() throws InterruptedException {
		
	driver.get("https://demo.opencart.com/en-gb?route=account/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	Thread.sleep(4000);		    
	}

	@Given("User enters valid user credential")
	public void user_enters_valid_user_credential() throws Exception {
	
	login.enterEmail("madhurakulkarni1981@gmail.com");
	login.enterPassword("test@246");
		
	}
    
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	login.clickLoginButton();	
	    
	}

	@Then("I validate user login successfully to OpenCart application")
	public void i_validate_user_login_successfully_to_open_cart_application() {
		
	// user navigates to My account page
		
	String pageTitle = "MyAccount";
	driver.getTitle();
	Assert.assertEquals(driver.getTitle(), pageTitle);
	
	}
    
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
	driver.get("https://www.opencart.com/index.php?route=account/login");	
	    
	}

	@When("User enters invalid user {string} and {string} credential")
	public void user_enters_invalid_user_and_credential(String username, String password) {
	
	login.enterEmail(username);	
	login.enterPassword(password);
	login.clickLoginButton();
		
	}
   
	@Then("I validate user can see error message {string}")
	public void i_validate_user_can_see_error_message(String string) {
		
		login.showerrorMessage();
		String expectedError="email and password not matching";
		Assert.assertEquals(login.showerrorMessage(),expectedError);
		
	}

	


	
	

}
