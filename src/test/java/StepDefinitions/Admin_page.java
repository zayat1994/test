package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.math3.analysis.function.Add;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDate;
import java.time.LocalTime;
public class Admin_page {
//	 @Then("browser switch tab")
//	public static void swich_tab() throws InterruptedException
//	{
//		
//		Main.driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.SECONDS);
//	Main.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
//		String parent = Main.driver.getWindowHandle();
//		Set<String> s = Main.driver.getWindowHandles();
//		java.util.Iterator<String> I1 = s.iterator();
//		
//		while (I1.hasNext()) {
//			String child_window = I1.next();
//			if (!parent.equals(child_window)) {
//				Main.driver.switchTo().window(child_window);
//				Thread.sleep(10000);
//			
//				
//				
//
//			}
//		}
//	}
	
	 @Given("user open the admin page")
	 public static void open_admin()
	 {
		WebElement Admin_btn=Main.driver.findElement(By.xpath("//li[1]//a[1]//span[1]"));
		Admin_btn.click();
		 
	 }
@Then ("User can check the number of records")
	 public static int number_of_records()
	 {
		WebElement records=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
		String text_records=records.getText();
		java.util.regex.Matcher m = Pattern.compile("\\((.*?)\\)").matcher(text_records);
		String actual_number_of_record="";
		int number_of_records=0;
		while (m.find())
		{
			
			actual_number_of_record=(m.group(1));
		}
		
		number_of_records=Integer.valueOf(actual_number_of_record);
		System.out.println("number of records: "+number_of_records);
		return number_of_records;
		 
	 }

	
	 


}
