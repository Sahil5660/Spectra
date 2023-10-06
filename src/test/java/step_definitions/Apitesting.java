package step_definitions;



import com.aventstack.extentreports.Status;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import RestUtils.RestUtils;
import utilities.*;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.powermock.api.mockito.PowerMockito.when;

public class Apitesting {
    public static HashMap<String, String> datamap = null;
    public static String jsonObjectString = null;
    public static Response response = null;

    public static String access_token="";









    @Given("read the data from {string}")
    public void read_data_from_json(String filename){
        try {

            jsonObjectString = Files.toString(new File(System.getProperty("user.dir") +"\\src\\test\\resources\\testData\\"+filename+".txt"),
                    Charsets.UTF_8);
            KeywordUtil.cucumberTagName = "@APItests";
        } catch (Throwable e) {
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }


    }

    @When("i sent the post request to {string} and device id is {string}")
    public void sent_post_request(String endpoint,String deviceid){
        response=RestUtils.post_req(endpoint,jsonObjectString,deviceid);
        ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("the body is : " +response.asString()));
    }

    @When("i sent the get request to {string}")
    public void get_request(String endpoint){
        try {

            response= RestUtils.get_user(endpoint, access_token);
            ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("the body is : " +response.asString()));

        } catch (Throwable e) {
            GlobalUtil.errorMsg = e.getMessage();
            ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("get request not sent"));

            Assert.fail(e.getMessage());
        }
    }






    @Then("getting the access token")
    public void access_token(){
        ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("access token is " +RestUtils.getValueFromJson(response,"token.access_token","access token")));
        access_token= (String) RestUtils.getValueFromJson(response,"token.access_token","access token");
        System.out.println("the access token is : " +access_token);


    }






    @Then("^I verify the status as \"([^\"]*)\"$")
    public void i_verify_the_status_as(String arg1) {
        try {
            Assert.assertEquals(Integer.toString(response.getStatusCode()), arg1, "Status Check pases");
            ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor("status code is correct"));

        } catch (Throwable e) {
            GlobalUtil.errorMsg = e.getMessage();
            ExtentUtil.logger.get().log(Status.FAIL, HTMLReportUtil.failStringRedColor("Status code is not correct"));

            Assert.fail(e.getMessage());
        }
    }







}
