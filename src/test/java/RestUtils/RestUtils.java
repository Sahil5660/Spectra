package RestUtils;


import com.aventstack.extentreports.Status;

import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import step_definitions.RunCukesTest;
import utilities.ExtentUtil;
import utilities.HTMLReportUtil;

import io.restassured.RestAssured;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class RestUtils {
	// Global Setup Variables
	public static String path;
	public static String jsonPathTerm;
	static RequestSpecification rs;
	// public static

	// Sets Base URI

	public static Response get_user(String url,String accesstoken){
        Response res= given()
				.header("Authorization","Bearer "+accesstoken)
				.header("origin","https://finance-test.spektra.co")
				.when()
				.get(url);
		return res;


	}

	public static Response get_user(String url,String accesstoken,String queryheader,String queryvalue){
		Response res= given()
				.header("Authorization","Bearer "+accesstoken)
				.header("origin","https://finance-test.spektra.co")
				.queryParam(queryheader,queryvalue)
				.when()
				.get(url);
		return res;


	}

	public static Response post_req(String url,String data, String deviceid){
		Response res=  given()
				.baseUri(url)
				.contentType("application/json")
				.header("Authorization","Basic T2prQ01SSzlNYW44WGhzMmtnZ3ppTnV4Uk5KY1Z0V2dCaU5BeEFxTjpwV2N3OXdxTktpVW8xMXFTVWNmckxJdW5nWXd2Nnh4RncyM2NrTEloOGpiV3lPNDl3cU5EV29FNTlta1dkcGplTG1EZE1zMjJ0bjJYVGNUNnR2Y0ZSTlRCaUwwUHBsYjhZNWJsQ3NSanZEeVVGSFJOZG5XTEtaWEswaGFJN0xnMQ==")
				.header("Origin","https://test.spektra.co")
				.header("origin","https://finance-test.spektra.co")
				.header("brand","a")
				.header("device","a")
				.header("deviceId",deviceid)
				.header("Cookie","visid_incap_2789245=gnbnKdrBQZyMwb9B9s8W20hHk2IAAAAAQUIPAAAAAAAu/fJQ9gTz1j8CiZ7Hdlbk")
				.body(data)

				.when()
				.post();

		return res;

	}





	// Returns JsonPath object
	public static JsonPath getJsonPath(Response res, String logStep) {
		String json = res.asString();
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return new JsonPath(json);
	}

	// Verify the http response Status returned. Check Status Code is 200?
	public static void checkStatusIs200(Response res) {
		Assert.assertEquals(200, res.getStatusCode(), "Status Check Failed!");
	}

	public static Object getValueFromJson(Response res, String path, String logStep) {
		String json = res.asString();
		ExtentUtil.logger.get().log(Status.PASS, HTMLReportUtil.passStringGreenColor(logStep));
		return new JsonPath(json).getString(path);

	}
}