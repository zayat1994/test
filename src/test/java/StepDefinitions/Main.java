package StepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openxml4j.document.spreadsheet.ExcelDocument;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Main {
	private static boolean remote = false;
	private static String proxy = "";
	public static WebDriver driver;
	public static FirefoxOptions options = new FirefoxOptions();
	
	public static void DriverPath() {
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/drivers/geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	}

	@Given ("user opens url")
	public static void openUrl() throws InterruptedException {
		if (remote) {
			// System Property for Chrome Driver
			String nodeURL = "http://hub:4444/wd/hub/";
			// Set options for ChromeDriver
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--lang=en");
			options.addArguments("--headless");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--whitelisted-ips=''");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			if (proxy != null && proxy.length() != 0) {
				options.addArguments("--proxy-server=" + proxy);
			}
			try {
				driver = new RemoteWebDriver(new URL(nodeURL), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver(options);

//			DriverPath();
//			
//			driver = new FirefoxDriver(options);
			driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			try {
				driver.get("https://opensource-demo.orangehrmlive.com/");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@When("user enter credentials")
	public static void credentials() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("admin123");
		
		
	}

	@Then("login is successful")
	public static void login_is_successful() throws InterruptedException {
		WebElement Login_btn = driver.findElement(By.xpath("//button[@type='submit']"));
		Login_btn.click();
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		DriverPath();

		openUrl();
		credentials();
		login_is_successful();
		Admin_page admin=new Admin_page();
		
		admin.open_admin();
		admin.number_of_records();
		
		Add_user add_user=new Add_user();
		
		add_user.Add_User_page();
		
		add_user.enter_data();
		
		add_user.save();
		
		Delete_user delete=new Delete_user();
		
		delete.search();
		delete.delete();

	}

}
