package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinationLogin {
	 static WebDriver driver;


	@Given("^Login webPage$")
	public void login_webPage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\BDDFrameWorkPractice\\src\\test\\resources\\driver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}

	@SuppressWarnings("deprecation")
	@When("^title of login page is free CRM$")
	public void title_of_login_page_is_free_CRM()  {
		Assert.assertEquals("OrangeHRM", driver.getTitle());

	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException  {
		WebElement un=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		un.sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(5000);
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button()  {	

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@type='submit']")));
	}
}
