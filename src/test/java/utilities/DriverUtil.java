package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import com.aventstack.extentreports.ExtentTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import step_definitions.Hooks;
import step_definitions.RunCukesTest;




public class DriverUtil {
	public static final String IE = "IE";
	public static final String REMOTE = "BrowserStack";
	public static final String EDGE = "edge";
	public static final String CHROME = "Chrome";
	public static final String FIREFOX = "Firefox";
	public static final String SAFARI = "Safari";
     public static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static String deviceName = null;
	public static String osVersion = null;
	 public static AppiumDriverLocalService service;
	 private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	 
	
	private DriverUtil() {

	}
	public static AndroidDriver<MobileElement> invokeLocalMobileApp(String exeEnv, String deviceDetails) {
		
		String deviceName = deviceDetails.split("_")[0];
		String osVersion = deviceDetails.split("_")[1];

		System.out.println(deviceName);
		System.out.println(osVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
		capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Sahil Sharma\\eclipse-workspace\\Dash_generic_framework\\Dashboard_Appium_framework\\src\\test\\resources\\APK\\ke-build9.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		try {
			GlobalUtil.mdriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.err.println("");
			e.printStackTrace();
		}
		GlobalUtil.mdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return GlobalUtil.mdriver;
	}
	public static void closeAllDriver() {

		drivers.entrySet().forEach(key -> {
			key.getValue().quit();
			key.setValue(null);
		});

		LogUtil.infoLog(DriverUtil.class, "Closing Browsers");
	}

	public static WebDriver getBrowser(String exeEnv, String browserName) {
		WebDriver browser = null;
		try {
			String URL = null;

			MutableCapabilities capabilities = new MutableCapabilities();

			capabilities.setCapability("browserstack.debug", "true");
			capabilities.setCapability("build", GlobalUtil.getCommonSettings().getBuildNumber());

			HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

			browserstackOptions.put("os", GlobalUtil.getCommonSettings().getRemoteOS().split("_")[0]);
			browserstackOptions.put("osVersion", GlobalUtil.getCommonSettings().getRemoteOS().split("_")[1]);
			browserstackOptions.put("browserVersion", "latest");
			browserstackOptions.put("local", "false");
			browserstackOptions.put("projectName", GlobalUtil.getCommonSettings().getProjectName());
			browserstackOptions.put("buildName", GlobalUtil.getCommonSettings().getBuildNumber());
			browserstackOptions.put("sessionName", Hooks.testCaseDescription);

			if (exeEnv.equals("REMOTE")) {

				if (GlobalUtil.getCommonSettings().getRemoteOS().toUpperCase().contains("WINDOWS")) {
					if (browserName.equalsIgnoreCase(CHROME)) {
						capabilities.setCapability("browserName", CHROME);
					} else if (browserName.equalsIgnoreCase(EDGE)) {
						capabilities.setCapability("browserName", EDGE);
					} else if (browserName.equalsIgnoreCase(FIREFOX)) {
						capabilities.setCapability("browserName", FIREFOX);
					} else {
						throw new Exception("Browser name provided in automation control sheet is not valid. Please change it.");
					}
				} else if (GlobalUtil.getCommonSettings().getRemoteOS().toUpperCase().contains("OS X")) {
					if (browserName.equalsIgnoreCase(SAFARI)) {
						capabilities.setCapability("browserName", SAFARI);
					} else if (browserName.equalsIgnoreCase(CHROME)) {
						capabilities.setCapability("browserName", CHROME);
					} else if (browserName.equalsIgnoreCase(EDGE)) {
						capabilities.setCapability("browserName", EDGE);
					} else if (browserName.equalsIgnoreCase(FIREFOX)) {
						capabilities.setCapability("browserName", FIREFOX);
					} else {
						throw new Exception("Browser name provided in automation control sheet is not valid. Please change it.");
					}
				} else {
					throw new Exception("Remote OS name provided in automation control sheet is not valid. Please change it.");
				}

				try {
					capabilities.setCapability("bstack:options", browserstackOptions);

					URL = "https://" + GlobalUtil.getCommonSettings().getHostName() + ":" + GlobalUtil.getCommonSettings().getKey() + "@hub-cloud.browserstack.com/wd/hub";

					browser = new RemoteWebDriver(new URL(URL), capabilities);
				} catch (Exception e) {
					e.printStackTrace();
				}
				drivers.put(browserName, browser);

			} else {
				browser = drivers.get(browserName);
				if (browserName.equalsIgnoreCase(CHROME)) {
					if (browser == null) {
						Map<String, Object> prefs = new HashMap<String, Object>();
						String downloadPath= System.getProperty("user.dir")
								+File.separator+"target"+File.separator+"download";
						File dir = new File(downloadPath);
						if (!dir.exists()) dir.mkdirs();
						FileUtils.cleanDirectory(new File(downloadPath));
						prefs.put("download.default_directory", downloadPath);
						WebDriverManager.chromedriver().setup();
						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.addArguments("--remote-allow-origins=*");
						chromeOptions.setExperimentalOption("prefs", prefs);
						browser = new ChromeDriver(chromeOptions);
						drivers.put("Chrome", browser);
					}
				}

				else if (browserName.equalsIgnoreCase(IE)) {
					if (browser == null) {
						WebDriverManager.iedriver().arch32().setup();
						InternetExplorerOptions ieO = new InternetExplorerOptions();
						ieO.setCapability("ie.ensureCleanSession", true);
						ieO.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
						browser = new InternetExplorerDriver(ieO);
						drivers.put("IE", browser);
					}
				}

				else if (browserName.equalsIgnoreCase(FIREFOX)) {
					if (browser == null) {
						WebDriverManager.firefoxdriver().setup();
						browser = new FirefoxDriver();
						drivers.put("Firefox", browser);
					}
				}

				else if (browserName.equalsIgnoreCase(EDGE)) {
					if (browser == null) {
						WebDriverManager.edgedriver().arch32().setup();
						browser = new EdgeDriver();
						drivers.put("Edge", browser);
					}
				}
			}
			browser.manage().window().maximize();
			LogUtil.infoLog(DriverUtil.class, GlobalUtil.getCommonSettings().getBrowser() + " : Browser Launched and Maximized.");
		} catch (Exception e) {
			LogUtil.errorLog(DriverUtil.class, "Browser not launched. Please check the configuration ", e);
			e.printStackTrace();
		}
		return browser;
	}
	

	

	

}

