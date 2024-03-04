package StepDefinitions;

import java.util.regex.Pattern;

import org.jpmml.model.annotations.Added;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_user {
	
	
	@Given("search for username") 
	 public static void search()
	 {
	
		 System.out.println("number of record after add= "+ Add_user.number_of_records());
		 
		 WebElement search_box=Main.driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		 
		 search_box.sendKeys("zayat1994");
		 
		 WebElement search_btn=Main.driver.findElement(By.xpath("//button[@type='submit']"));
		 
		 search_btn.click();

		 
	 }
	 @When("delete username")
	 public static void delete() {
		 
		 
		 WebElement delete_btn=Main.driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']"));
		 
		 delete_btn.click();
		
		 WebElement approve=Main.driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']"));
		 
		 approve.click();
		
	}
	 @Then("number of records decrease by 1")
	 public  static boolean check_records() {
		
		 WebElement reset_search = Main.driver.findElement(By.xpath("//button[normalize-space()='Reset']"));
		 
		 reset_search.click();
		 
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
			System.out.println("number of records after delete : "+number_of_records);
			
			if ((number_of_records)==Admin_page.number_of_records())
			{
				return true;
				
				
			}
			else {
			return false;
			
			}
		 
		 
	}

}
