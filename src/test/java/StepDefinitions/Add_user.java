package StepDefinitions;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLSelectElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Add_user {
	
	
	 @Given("user opens the admin page")
	 public static void Add_User_page() 
	 {
		 WebElement Add_btn=Main.driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		 Add_btn.click();
	 }
	 @When("user enters data")
	 public static void enter_data() throws InterruptedException
	 {
		 
		 WebElement role =Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div"));
		 
		 role.click();
		 
		 WebElement admin=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]"));
		 
		 admin.click();
		 
		
		 Thread.sleep(3000);	
		 
		 
		 WebElement Emp_name=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input"));
		 
		 Emp_name.sendKeys("Harrison  5");
		 Thread.sleep(3000);
		 
		 WebElement emp=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]"));
		 
		 emp.click();
		 Thread.sleep(3000);
		 
		 WebElement Status=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i"));
		 
		 
		 Status.click();
		 
		 
		 WebElement Enabeled=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]"));
		 
		 Enabeled.click();
		 
		 
		 Thread.sleep(3000);
		 WebElement user_name=Main.driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
		 
		 user_name.sendKeys("zayat1994");
		 WebElement Password=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
		 Password.sendKeys("omar123456@");
		 WebElement retype_pass=Main.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
		 retype_pass.sendKeys("omar123456@");
		 
		 
	 }
	 @Then("user is added")
	 public static void save() {
		 
		 WebElement submit_btn=Main.driver.findElement(By.xpath("//button[@type='submit']"));
		 
		 submit_btn.click();
		
	}
	 @Then("number of records is increased by 1")
	 public static boolean number_of_records()
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
		System.out.println("number of records after add : "+number_of_records);
		
		if ((number_of_records+1)==Admin_page.number_of_records())
		{
			return true;
			
			
		}
		else {
		return false;
		
		}
		 
	 }

}
