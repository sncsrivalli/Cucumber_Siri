package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLabsLoginSteps {
	WebDriver driver;
	
	/*
	 * @Before => execute before each scenario
	 * @After => execute after each scenario
	 * @BeforeStep => executes before each step
	 * @AfterStep => executes after each step
	 */
	
	@Before
	public void beforeScenario() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("I will navigate to swag labs app")
	public void i_will_navigate_to_swag_labs_app() {
	    driver.get("https://www.saucedemo.com/");
	}

	@When("I will enter valid username and password")
	public void i_will_enter_valid_username_and_password() {
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.name("password")).sendKeys("secret_sauce");
	}

	@And("I will click on LOGIN")
	public void i_will_click_on_login() {
	    driver.findElement(By.name("login-button")).click();
	}

	@Then("I should navigate to swag labs home page")
	public void i_should_navigate_to_swag_labs_home_page() {
	    String header = driver.findElement(By.cssSelector("span.title")).getText();
	    if(header.equals("Products"))
	    	System.out.println("Pass");
	    else
	    	System.out.println("Fail");
	}
	
	@When("^I enter (.*) and (.*)$")
	public void i_will_enter_user_and_pwd(String user, String pwd) {
		driver.findElement(By.id("user-name")).sendKeys(user);
	    driver.findElement(By.name("password")).sendKeys(pwd);
	}
	
	@After
	public void afterScenario() {
	    driver.quit();
	}

}
