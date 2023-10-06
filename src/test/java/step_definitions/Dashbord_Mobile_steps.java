package step_definitions;

import RestUtils.RestUtils;
import com.aventstack.extentreports.Status;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.DashMobileLocators;
import utilities.*;

import javax.lang.model.type.ExecutableType;

//pushed to git hub newwwwwwwwwwwwwwww
public class Dashbord_Mobile_steps extends KeywordUtil {
@Given("open the app on emulator {string}")
    public void open_chrome_on_emulator(String deviceDetails){
    try {

        if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Local"))
            DriverUtil.invokeLocalMobileApp(GlobalUtil.getCommonSettings().getExecutionEnv(), deviceDetails);

        else if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote"))
            DriverUtil.invokeLocalMobileApp(GlobalUtil.getCommonSettings().getExecutionEnv(),deviceDetails);

    } catch (Exception e) {
        GlobalUtil.errorMsg = e.getMessage();
        Assert.fail(e.getMessage());
    }

}

@When("user clicks on the login button")
    public void click_login() throws InterruptedException {
	 Thread.sleep(5000);
    click(DashMobileLocators.loginBtn,"click on login button");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();

   
}

@When("user clicks on the continue button")
    public void click_continue() throws InterruptedException{
	Thread.sleep(3000);   
	click(DashMobileLocators.clickContinueBtn,"click on continue button");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
@When("user grants the permission")
    public void grants_permissioon(){
    click(DashMobileLocators.LocPermissionBtn,"click on location permission");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();

}
@When("user enter the mobile number as {string}")
    public void user_enters_mobile_number(String phone){
    writeInInput("android.widget.EditText", "className", phone, "Enter the number in textBox");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
/*
 * @When("user clicks on continue button") public void click_continue1(){
 * click(Dashboard_locators.ClickContinueBtn2,"click on continue button"); }
 */

@When("user enters the pin {string},{string},{string},{string}")
    public void enters_pin_number(String a, String b, String c,String d) throws InterruptedException{
   click(DashMobileLocators.clickDigit(a),"click on the " +a);
    click(DashMobileLocators.clickDigit(b),"click on the " +b);
    click(DashMobileLocators.clickDigit(c),"click on the " +c);
    click(DashMobileLocators.clickDigit(d),"click on the " +d);
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
    Thread.sleep(8000);
}
@When("user clicked on send button")
public void click_send_button() throws InterruptedException{
Thread.sleep(4000);
click(DashMobileLocators.ClickSendButton,"click on send button");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
Thread.sleep(5000);

}
@When("user clicked on enter phone number")
public void click_on_PhoneNumberButton() throws InterruptedException{
Thread.sleep(4000);
click(DashMobileLocators.enterPhoneNo,"Click on enter phone number button");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
Thread.sleep(4000);

}
@When("user enter the mobile number to send money")
public void user_enters_mobile_number_to_send_money(){
writeInInput("android.widget.EditText", "className", "712345678", "Enter the number in textBox");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
/*
 * @When("user clicks on continue button2") public void click_continue2(){
 * click(Dashboard_locators.clickContinueBtn,"click on continue button");
 * ExtentUtil.attachScreenshotOfPassedTestsInReport(); }
 */

@When("user enter the fund for transfer")
public void enter_money() throws InterruptedException{
click(DashMobileLocators.clickDigit("1"),"click on the 1");
Thread.sleep(4000);
ExtentUtil.attachScreenshotOfPassedTestsInReport();

}
@When("user click on where to?")
public void click_WhereTo(){
click(DashMobileLocators.ClickOnWhereTo,"Click on where to down arrow");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}

@When("user click on checkbox")
public void click_on_checkbox(){
click(DashMobileLocators.ClickOnCheckBox,"Click on check box");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}

/*
 * @When("user clicks on continue button3") public void click_continue3() throws
 * InterruptedException{ Thread.sleep(2000);
 * click(Dashboard_locators.clickContinueBtn,"click on continue button3");
 * ExtentUtil.attachScreenshotOfPassedTestsInReport(); }
 */

/*
 * @When("user clicks on continue button4") public void click_continue4() throws
 * InterruptedException{ Thread.sleep(2000);
 * click(Dashboard_locators.clickContinueBtn,"click on continue button4");
 * ExtentUtil.attachScreenshotOfPassedTestsInReport(); }
 */
@When("user clicks on skip Button")
public void click_skip_btn() throws InterruptedException{
Thread.sleep(2000);
click(DashMobileLocators.ClickOnSkip,"click on skip button");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
@When("user select a catogory")
public void click_Catogory_btn() throws InterruptedException{
Thread.sleep(5000);
waitForVisible(DashMobileLocators.selectCatagory);
click(DashMobileLocators.selectCatagory,"click on catogory");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}

@When("user click on review and send")
public void click_reviewsend_btn() throws InterruptedException{
Thread.sleep(5000);
click(DashMobileLocators.reviewAndSend,"click on review and send");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}
@When("user click on send now button")
public void click_OnsendNow_btn() throws InterruptedException{
Thread.sleep(2000);
click(DashMobileLocators.ClickOnSendNow,"click on send now button");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}

    @When("user clicks on the Bills option")
    public void click_bills() throws InterruptedException {
        click(DashMobileLocators.ClickOnbills,"click on bills option");
        Thread.sleep(8000);
    }

    @When("user clicks on the {string}")
    public void get_Strated(String text) throws InterruptedException {
        waitForVisible(DashMobileLocators.mobile_button_text(text));
        click(DashMobileLocators.mobile_button_text(text),"click on the "+text + " button");
        ExtentUtil.attachScreenshotOfPassedTestsInReport();
        Thread.sleep(6000);

    }


    @And("user enter the amount")
    public void enter_amount() throws InterruptedException {
    click(DashMobileLocators.mobile_button_text("Enter Amount"),"click on the enter amount");
    Thread.sleep(4000);
    mdriver.findElement(DashMobileLocators.mobile_button_text("Enter Amount")).sendKeys("20");

//    click(Dashboard_locators.clickDigit("2"),"click on 2");
//    click(Dashboard_locators.clickDigit("5"),"click on 5");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();

    }

    @When("user clicks on the payonbill")
    public void click_pay(){
        click(DashMobileLocators.click_on_pay_a_bill,"click on pay a bill");
        ExtentUtil.attachScreenshotOfPassedTestsInReport();
    }

    @And("user enters the mobile number")
    public void enters_mobile_number(){

    }

    @When("user enters the amount as {string}")
    public void enter_amount(String amount ) throws InterruptedException {
    inputText(DashMobileLocators.enter_amount,amount,"enter the amount");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
    Thread.sleep(6000);
    }

    @Then("user is able to see the successful sent screen")
    public void successful(){
    Assert.assertTrue(isWebElementVisible(DashMobileLocators.mobile_button_text("View rewards"),"view rewards text is present"));
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
    }

    @Then("user should be able to see the pay a bill screen")
    public void user_should_able_tosee(){
    Assert.assertTrue(isWebElementVisible(DashMobileLocators.mobile_button_text("Pay a bill"),"pay a bill screen is visible"));
        ExtentUtil.attachScreenshotOfPassedTestsInReport();
    }

    @When("user enter the request amount")
    public void user_request_monry(){
    click(DashMobileLocators.clickDigit("1"),"enter the amount as 1 ");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
    }
    @Then("user is able to see the text {string}")
    public void validate_message(String text){
    String gettext=getElementText(DashMobileLocators.mobile_button_text(text));
        ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("user is able to see the  : " +gettext));
        ExtentUtil.attachScreenshotOfPassedTestsInReport();


    }

    @And("user enter the withdraw amount")
    public void enter_withdraw_amount(){
        click(DashMobileLocators.clickDigit("5"),"enter the amount as 5 ");
        click(DashMobileLocators.clickDigit("0"),"enter the amount as 0 ");
        click(DashMobileLocators.clickDigit("0"),"enter the amount as 0 ");
        ExtentUtil.attachScreenshotOfPassedTestsInReport();
    }

    @When("user clicks on the invite friends button")
    public void click_invite_friends() throws InterruptedException {
    scrollAndClick("INVITE FRIENDS");

   ExtentUtil.attachScreenshotOfPassedTestsInReport();
   Thread.sleep(4000);
}

@When("user clicks on the allow button")
    public void click_allow(){
    click(DashMobileLocators.Allow_btn,"clcik on the allow button");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();

}

@When("click on the plus button")
    public void click_search_button() throws InterruptedException {
    click(DashMobileLocators.plus_icon,"click on teh search button");
    ExtentUtil.attachScreenshotOfPassedTestsInReport();
    Thread.sleep(3000);
}

@When("user click on three dots")
    public void three_dots(){
    click(DashMobileLocators.threedots,"click on three dots");
}

@Then("user see the error message")
    public void error_message(){
    String toast_message=getMdriver().findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
    System.out.println(toast_message);
    }
@When("user clicks on the profile button")
public void click_profile_button(){
waitForVisible(DashMobileLocators.profile_button);
waitForClickable(DashMobileLocators.profile_button);
click(DashMobileLocators.profile_button,"click on the profile icon");
ExtentUtil.attachScreenshotOfPassedTestsInReport();
}



}
