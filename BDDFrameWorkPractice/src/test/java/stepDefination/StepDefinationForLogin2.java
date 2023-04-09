package stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinationForLogin2 {
	WebDriver driver;

	@Given("^Login page is given$")
	public void login_page_is_given() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\BDDFrameWorkPractice\\src\\test\\resources\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	@When("^Title of login page is xyz$")
	public void title_of_login_page_is_free_CRM()  {
		Assert.assertEquals("OrangeHRM", driver.getTitle());

	}


	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable table) throws InterruptedException  {
		List<List<String>> data=table.asLists(String.class);
		WebElement un=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		un.sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get(1));
		Thread.sleep(5000);
	}

	@Then("^click ion login button$")
	public void user_click_on_login_button()  {	

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}
	
	
	
	




}
