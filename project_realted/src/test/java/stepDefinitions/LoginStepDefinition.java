package stepDefinitions;
/*import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import junit.framework.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.*;*/
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginStepDefinition {
	@Given("user is already on Login Page")
	public void user_is_already_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("asdhsa");
	}
	@When("title of login page is Free CRM")
	public void title_of_login_page_is_free_crm() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("asdhsa");
	}
	@When("user enters user name and password")
	public void user_enters_user_name_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("asdhsa");
	}
	
	@Then("user is on the home page")
	public void user_is_on_the_home_page() {
	    System.out.println("free");
	}
					
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		System.out.println("safaadasfasf");
	}

	@Then("user is on home page")
	public void user_is_on_hopme_page(){
		
		System.out.println("safasf");
				}
}
