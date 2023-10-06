package step_definitions;

import com.Buffer.BufferUtilSuiteLevel;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import mantisutil.MantisReport;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.ConfigReader;
import utilities.DriverUtil;
import utilities.ExtentUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;


public class Hooks {

	String imagePath;
	String pathForLogger;
	public static String testCaseDescription;
	public static String executingTagName;

	public static String imagePath1;
	public static String concatt = ".";



	@Before("@MobileTest4")
	public void beforeMobileMethods(Scenario scenario) throws Exception {
		if (scenario.getName().contains("_"))
			testCaseDescription = scenario.getName().split("_")[1];
		else
			testCaseDescription = scenario.getName();
		testCaseDescription = scenario.getName().split("_")[1];
		executingTagName = scenario.getSourceTagNames().toArray()[0].toString();
		ExtentUtil.startTestInit(testCaseDescription);
		LogUtil.infoLog(getClass(), "Test Started with tag : " + executingTagName);

		LogUtil.infoLog(getClass(),

				"\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Mobile Tests Started: " + scenario.getName());

		LogUtil.infoLog(Hooks.class,
				"Mobile Test is executed in OS: " + GlobalUtil.getCommonSettings().getAndroidName());

		//GlobalUtil.setMDriver(DriverUtil.getMobileApp());
		// GlobalUtil.setMDriver(DriverUtil.getMobileApp(GlobalUtil.getCommonSettings().getExecutionEnv()));
	}



	@After("@MobileTest4")
	public void afterMobileMethods(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if (scenario.isFailed()) {
			try {
				String scFileName = "ScreenShot_" + System.currentTimeMillis();
				String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";
				ExtentUtil.attachScreenshotToReportOnFailure(scenario);

				// imagePath = HTMLReportUtil.testFailMobileTakeScreenshot(screenshotFilePath);
				// pathForLogger = RunCukesTest.logger.addScreenCapture(imagePath);
				// RunCukesTest.logger.log(LogStatus.FAIL,
				// HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) +
				// GlobalUtil.e);

				// scenario.write("Current Page URL is " +
				// GlobalUtil.getMDriver().getCurrentUrl());

				// byte[] screenshot = KeywordUtil.takeMobileScreenshot(screenshotFilePath);

				// scenario.embed(screenshot, "image/png");

				// report the bug
				String bugID = "Please check the Bug tool Configuration";
				if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
							"Automated on Android Device Version: " + GlobalUtil.getCommonSettings().getAndroidVersion()
									+ " and Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(),
							screenshotFilePath);
				}

				/*if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
					bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(),
							"Automated on Android Device Version: " + GlobalUtil.getCommonSettings().getAndroidVersion()
									+ ",\n Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber()
									+ ". \n\n\n\n" + GlobalUtil.ErrorMsg,
							screenshotFilePath);
				}*/

				// updating the results in Testmangement tool
				if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
					GlobalUtil.testlinkapi
							.updateTestLinkResult(
									testName, "Please find the BUGID in "
											+ GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
									TestLinkAPIResults.TEST_PASSED);
				}
				if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "
							+ GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			LogUtil.infoLog(Hooks.class,
					"Test has ended closing Application: " + GlobalUtil.getCommonSettings().getAndroidName());
			// updating the results in Testmangement tool
			if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed",
						TestLinkAPIResults.TEST_PASSED);
			}
			if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		// close the browsers

		// We need to write the quit for local mobile device for time being we commented
		// for browser stack
		GlobalUtil.getMDriver().quit();
		
//		RunCukesTest.extent.flush();

	}
	
	@Before("@APItests")
	   public void beforeAPIMethod(Scenario scenario) {

	      if (scenario.getName().contains("_"))
	         testCaseDescription = scenario.getName().split("_")[1];
	      else
	         testCaseDescription = scenario.getName();
	      ExtentUtil.startTestInit(testCaseDescription);

	      LogUtil.infoLog(getClass(), "\n+----------------------------------------------------------------------------------------------------------------------------+");
	      LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
	      LogUtil.infoLog(getClass(), "Test Started with tag : " + scenario.getSourceTagNames());
	      executingTagName = scenario.getSourceTagNames().toArray()[0].toString();
	      LogUtil.infoLog(getClass(), "Test Started with tag : " + executingTagName);



	      LogUtil.infoLog(getClass(),
	            "\n+----------------------------------------------------------------------------------------------------------------------------+");
	      LogUtil.infoLog(getClass(), "API Test Started: " + scenario.getName());
//	    LogUtil.infoLog("Test Started",
//	          "Test is started using base URL: " + GlobalUtil.getCommonSettings().getRestURL());
	   }
	
	
	@After("@APItests")
	   public void afterAPIMethod(Scenario scenario) {
	      String testName = scenario.getName().split("_")[0].trim();
	      if (scenario.isFailed()) {
	         try {

	            // report the bug
	            String bugID = "Please check the Bug tool Configuration";
	            if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
	               bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
	                     " Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(), "RestAPI");
	            }

	            if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
	               // getting the os name to report the bug
	               String osName = System.getProperty("os.name");
	               if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")) {
	                  osName = GlobalUtil.getCommonSettings().getRemoteOS();
	               }
	               bugID = GlobalUtil.jiraapi.reporIssue(scenario.getName(),
	                     "Automated on OS: " + osName + "on Build Name: "
	                           + GlobalUtil.getCommonSettings().getBuildNumber() + ". \n\n\n\n"
	                           + GlobalUtil.errorMsg,
	                     "RestAPI");
	            }

	            // updating the results in Testmangement tool
	            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
	               GlobalUtil.testlinkapi
	                     .updateTestLinkResult(
	                           testName, "Please find the BUGID in "
	                                 + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
	                           TestLinkAPIResults.TEST_PASSED);
	            }
	            if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
	               GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in "
	                     + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
	            }

	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      } else {

//	       LogUtil.infoLog("TestEnded", "API Test has ended ");
	         // updating the results in Testmangement tool
	         if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
	            GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed",
	                  TestLinkAPIResults.TEST_PASSED);
	         }
	         if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
	            GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
	         }
	      }

	      // close the browsers
//	    RunCukesTest.extent.endTest(RunCukesTest.logger);
	   }

	@Before("@Web")
	public void beforeMethodAmazon(Scenario scenario) {

		if (scenario.getName().contains("_"))
			testCaseDescription = scenario.getName().split("_")[1];
		else
			testCaseDescription = scenario.getName();
		ExtentUtil.startTestInit(testCaseDescription);

		LogUtil.infoLog(getClass(), "\n+----------------------------------------------------------------------------------------------------------------------------+");
		LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
		LogUtil.infoLog(getClass(), "Test Started with tag : " + scenario.getSourceTagNames());
		executingTagName = scenario.getSourceTagNames().toArray()[0].toString();
		LogUtil.infoLog(getClass(), "Test Started with tag : " + executingTagName);
		LogUtil.infoLog(Hooks.class, "Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());

		LogUtil.infoLog(Hooks.class, "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());

		GlobalUtil.setDriver(DriverUtil.getBrowser(GlobalUtil.getCommonSettings().getExecutionEnv(),
				GlobalUtil.getCommonSettings().getBrowser()));

	}




	@After("@Web")
	public void afterMethodSmoke(Scenario scenario) {
		String testName = scenario.getName().split("_")[0].trim();
		if (scenario.isFailed()) {
			try {

				ExtentUtil.attachScreenshotToReportOnFailure(scenario);

				// report the bug
				String bugID = "Please check the Bug tool Configuration";
				if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Mantis")) {
					bugID = MantisReport.reporIssue(scenario.getName(), GlobalUtil.errorMsg, "General",
							"Automated on Browser: " + GlobalUtil.getCommonSettings().getBrowser() + " and Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber(),
							BufferUtilSuiteLevel.screenshotFilePath);
				}

				if (GlobalUtil.getCommonSettings().getBugToolName().equalsIgnoreCase("Jira")) {
					// getting the os name to report the bug
					String osName = System.getProperty("os.name");
					if (GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("Remote")) {
						osName = GlobalUtil.getCommonSettings().getRemoteOS();
					}
					bugID = GlobalUtil.jiraapi
							.reporIssue(
									scenario.getName(), "Automated on OS: " + osName + ",\n Automated on Browser: " + GlobalUtil.getCommonSettings().getBrowser()
											+ ",\n Build Name: " + GlobalUtil.getCommonSettings().getBuildNumber() + ". \n\n\n\n" + GlobalUtil.errorMsg,
									BufferUtilSuiteLevel.screenshotFilePath);
				}

				if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
					GlobalUtil.testlinkapi.updateTestLinkResult(testName, "Please find the BUGID in " + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID,
							TestLinkAPIResults.TEST_PASSED);
				}
				if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
					GlobalUtil.jiraapi.updateJiraTestResults(testName, "Please find the BUGID in " + GlobalUtil.getCommonSettings().getBugToolName() + " : " + bugID, "Fail");
				}

				LogUtil.infoLog(getClass(), "Trying to get Bug ID: " + bugID);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			LogUtil.infoLog(Hooks.class, "Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());
			if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("TestLink")) {
				GlobalUtil.testlinkapi.updateTestLinkResult(testName, "This test is passed", TestLinkAPIResults.TEST_PASSED);
			}
			if (GlobalUtil.getCommonSettings().getManageToolName().equalsIgnoreCase("Jira")) {
				GlobalUtil.jiraapi.updateJiraTestResults(testName, "This test is passed", "Pass");
			}
		}

		// close the browsers
		DriverUtil.closeAllDriver();
	}



}