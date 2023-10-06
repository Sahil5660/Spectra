package step_definitions;

import com.Buffer.BufferUtilSuiteLevel;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.opencsv.exceptions.CsvException;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.DashWebLocators;
import utilities.*;

import static org.testng.Assert.assertEquals;

import java.awt.Checkbox;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.Assert;

public class web_steps extends KeywordUtil {
	static Random random = new Random();
	static int random_number = random.nextInt(500);

	public static HashMap<String, String> dataMap = new HashMap<String, String>();
	public static String project_name = "";

	@Given("Read the testdata {string} and {string} from excel file")
	public void readTheTestdataFromExcelFile(String arg1, String arg2) {
		dataMap = ExcelDataUtil.getTestDataWithTestCaseID(arg2, arg1);
	}

	@Given("user navigates to the application")
	public void navigates_to_the_application() {
		navigateToUrl(dataMap.get("URL"));
		ExtentUtil.attachScreenshotOfPassedTestsInReport();
	}

	
	@And("click on the {string} option")
	public void clicktemplates(String dropdownname) throws InterruptedException {
		waitForVisible(DashWebLocators.dropdown_buttons(dropdownname));
		waitForClickable(DashWebLocators.dropdown_buttons(dropdownname));
		click(DashWebLocators.dropdown_buttons(dropdownname), "click on the " + dropdownname + " option");
		ExtentUtil.attachScreenshotOfPassedTestsInReport();

	}
	
// other test case

	@When("user clicked on the login button")
	public void clicked_login_Btn() throws InterruptedException {
		Thread.sleep(6000);
		click(DashWebLocators.Login, "click on the Login in button");
	}
	
	@When("user enters the emailaddress and password")
	public void entertheemailandpassword() {
		inputText(DashWebLocators.enter_emailadders, dataMap.get("Username"), "enter the username");
		inputText(DashWebLocators.enter_passwords, dataMap.get("Password"), "enter the password");
		
}
	
	@And("click on the admin name")
	public void Click_Admin() throws InterruptedException {
		waitForVisible(DashWebLocators.Adminname);
		click(DashWebLocators.Adminname, "click on the Admin name");
		Thread.sleep(5000);
	}
	@And("Select the admin {string} option")
	public void select_admin_dropdown(String admin) throws InterruptedException {
		waitForClickable(DashWebLocators.Admin_dropdown(admin));
		click(DashWebLocators.Admin_dropdown(admin), "click on the Setting option");
		
}
	@And("click on createuser button")
	public void click_createuser_button() throws InterruptedException {
		click(DashWebLocators.click_on_Createuser, "click on the Createuser button");
		Thread.sleep(4000);
		ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
	@And("Select the Countries {string} option")
	public void select_Countries_dropdown(String admin) throws InterruptedException {
		Thread.sleep(4000);
		click(DashWebLocators.Countries_dropdown(admin), "click on the Countries dropdwon");		
	  
}
	@And("Select the Group {string} option")
	public void select_Group_dropdown(String admin) throws InterruptedException {
		Thread.sleep(4000);
		click(DashWebLocators.Group_dropdown(admin), "click on the Group dropdwon");		
	 //   ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
	@And("enters the  {string} in the field")
	public void enter_details_fields(String field_name) throws InterruptedException {
		inputText(DashWebLocators.enter_details(field_name), dataMap.get(field_name),
				"enter the " + dataMap.get(field_name) + " in the " + field_name);
}
	
	@When("click on the {string} button") public void click_Add_tempalte(String
			 buttonname) throws InterruptedException {
			  
			  scrollingToElementofAPage(DashWebLocators.button_by_text(buttonname),
			  "move to the " + buttonname);
			  waitForVisible(DashWebLocators.button_by_text(buttonname));
			//  ExtentUtil.takeScreenshotAndAttachInReport();
			 click(DashWebLocators.button_by_text(buttonname), "click on the " + buttonname +
			 "button"); Thread.sleep(6000); click_on_empty_space();
			 
			  }
	@And ("enters the  {string} in the emailfield") 
	public void enterEmail(String field_name) {
		inputText(DashWebLocators.enter_details(field_name),"admin"+random_number+"@gmail.com",
				"enter the emailAddress " + field_name);
	}
}