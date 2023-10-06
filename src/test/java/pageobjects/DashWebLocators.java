package pageobjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashWebLocators {




	public static By button_by_text(String buttonname) {
		return By.xpath("//button[text()='" + buttonname + "']");
	}

	public static By dropdown_buttons(String buttonname) {
		return By.xpath("//a[text()='" + buttonname + "']");
	}

	

	public static By template_manage_button(String template_name) {
		return By.xpath(
				"//td[text()=' " + template_name + " ']//following-sibling::td[1]//button[@class='btn btn btn-view']");
	}

	public static By template_Manage_dropdowns(String templatename, String dropdownname) {
		return By.xpath("//td[text()=' " + templatename
				+ " ']//following-sibling::td[1]//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='"
				+ dropdownname + "']");
	}

	public static By manage_button(String project_name) {
		return By.xpath(
				"//td[text()=' " + project_name + " ']//following-sibling::td[3]//button[@class='btn btn btn-view']");
	}

	public static By Edit_Template_heading = By.xpath("//h1[text()='Edit Template']");

	public static By Manage_dropdowns(String projectname, String dropdownname) {
		return By.xpath("//td[text()=' " + projectname
				+ " ']//following-sibling::td[3]//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='"
				+ dropdownname + "']");
	}

	public static By checkboxActivityTemplate = By
			.xpath("//input[@type='checkbox' and contains(@class,'dirty')]//parent::div");

	public static By checkboxActivityTemplate(int index) {
		return By.xpath("(//input[@type='checkbox' and contains(@class,'dirty')]//parent::div)[" + index + "]");
	}

	public static By displayParticipantLabel = By.xpath("//label[text()='Display participant list without search']");

	public static By activityCardInstruction = By.xpath("//input[@id='activity_card_instruction']");

	public static By mobileACSReport = By.xpath("//input[@id='mobile_acs_instruction']");

	public static By remoteACSReport = By.xpath("//input[@id='remote_acs_instruction']");

	public static By updateBtn = By.xpath("//button[text()=' Update Details ']");

	public static By allAvoutActivity = By.xpath("//label[text()='Ask about activities that they do with others']");

	public static By activityCardOptions(String activityradioBtnText) {
		return By.xpath("//span[text()='" + activityradioBtnText + "']//ancestor::label//span[@class='cr']");
	}

	public static By projectList(String project) {
		return By.xpath(
				"//table[@class='table table-striped']//tr//td[@class='semi-bold' and text()=' " + project + " ']");
	}

	public static By settingTemplateList = By.xpath("//select[@id='setting_template_id ']//option");

	public static By nextBtn = By.xpath("//a[text()=' Next ']");

	public static By view_details = By.xpath("//a[text()='View details']");

	public static By Edit_Project_heading = By.xpath("//h1[text()='Edit Project']");

	public static By checkbox_project_doing_with_others = By
			.xpath("//input[@type='checkbox' and @id='project_doing_with_others']//parent::div");

	public static By select_project_template_setting = By.xpath("//select[@id='setting_template_id ']");

	public static By select_template_name(String templatename) {
		return By.xpath("//select[@id='setting_template_id ']/option[text()=' " + templatename + " ']");

	}

	public static By selectCheckbox(String checkboxTxt) {
		return By.xpath("//label[text()='" + checkboxTxt + "']//ancestor::label//div[@class='check-bottom']");
	}

	public static By search_results = By.xpath("//table[@class='table table-striped']//tr//td[@class='semi-bold']");

	public static By update_projectBtn = By.xpath("//button[text()='Update Project']");

	public static By selected_checkboxes = By.cssSelector("input:checked[type='checkbox']");

	@FindBy(css = "input:checked[type='checkbox']")
	public static WebElement checkbox;

	public static By Manage_Professional = By.xpath("//button[text()=' Manage Professional ']");

	public static By ManageProfessional_dropdown(String Professional) {
		return By.xpath("//div[@class='btn-group dropdown-user']//a[text()='" + Professional + "']");
	}

	public static By existing_professional(String pname) {
		return By.xpath("//div[@title='list professional']//ul/li/a[text()='" + pname + "']");
	}

	public static By selectProfessionalUserAdminCheckbox(String pname) {
		return By.xpath("//td[text()='" + pname + "']//following-sibling::td[2]");
	}

	public static By existing_professionals = By.xpath("//div[@class='table-responsive']//td[2]");

	public static By status_text(String text) {
		return By.xpath("//td[text()=' " + text + " ']//following-sibling::td[1]");
	}

	public static By Research_text(String text) {
		return By.xpath("//td[text()=' " + text + " ']//following-sibling::td[2]");
	}

	public static By manage_dropdown(String text) {
		return By.xpath("//td[text()=' " + text + " ']//following-sibling::td[3]");
	}

	public static By First_name = By.xpath("//input[@placeholder='Enter first name']");

	public static By Last_name = By.xpath("//input[@placeholder='Enter last name']");

	public static By Email_address = By.xpath("//input[@placeholder='Enter email address']");

	public static By Submit_button = By.xpath("//button[text()=' Submit ']");

	public static By admin_box = By.xpath("//div[@class='checkbox']");

	public static By Edit_Project = By.xpath("//h1[text()='Edit Project']");

	public static By activate_button(String text, String buttoname) {
		return By.xpath("//tr[@class='ng-star-inserted']//td[text()='" + text
				+ "']//following-sibling::td[1]//button[text()='" + buttoname + "']");

	}

	



//public static By select_ActivitiesOption=By.xpath("//span[text()='Activity takes too long']");



 public static By select_ActivitiesOption(String Checkbox) {
	return By.xpath("//span[contains(text(),'" + Checkbox + "')]");
 }
 // other tc
 public static By enter_emailadders = By.xpath("//input[@placeholder='Email Address']");
 
 public static By enter_passwords = By.xpath("//input[@placeholder='Password']");
 
 public static By Login = By.xpath("//button[@type='submit']");
 
	public static By Adminname = By.xpath("//a[@class='dropdown-toggle']");


public static By Admin_dropdown(String admin) {
	return By.xpath("//li[@class='navbar-profile dropdown open']//a[contains(text(),'Settings')]");
}
 public static By click_on_Createuser = By.xpath("//button[@class='credit-account-button']");
 
	public static By Countries_dropdown(String Countri) {
		return By.xpath("//div[@class='modal-textbox-marg']//option[contains(text(),'"+ Countri +"')][1]");
	}


public static By Group_dropdown(String acs) {
	return By.xpath("//select[@name='groupId']//option[contains(text(),'Administrator')]");
}
public static By enter_details(String field) {
	return By.xpath("//input[@name='" + field + "']");
}

}