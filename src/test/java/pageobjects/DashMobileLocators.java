package pageobjects;

import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import org.openqa.selenium.By;


public class DashMobileLocators {
    public static By loginBtn= By.className("android.widget.Button");
    public static By clickContinueBtn=By.xpath(
            "//android.widget.TextView[@text='Continue']"
    );
    public static By grantPermissionsBtn=By.id("com.android.packageinstaller:id/permission_allow_button");

    public static By LocPermissionBtn=By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    public static By Allow_btn=By.id("com.android.permissioncontroller:id/permission_allow_button");

    public static By allow_btn=By.xpath("//android.widget.Button[@text()='Allow']");

    public static By plus_icon=By.xpath("(//android.widget.Button)[2]");

    //public static By ClickContinueBtn2=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    public static By clickDigit(String digit) {

        return By.xpath("//android.widget.TextView[@text='"+digit+"']");

    }
    public static By ClickSendButton=By.xpath("(//android.widget.ImageView)[4]");
    public static By enterPhoneNo=By.xpath("//android.widget.TextView[@text='Enter phone number']");
	/*
	 * public static By clickDigitForFund(String digit) {
	 * 
	 * return By.xpath("//android.widget.TextView[@text='"+digit+"']");
	 * 
	 * }
	 */
    public static By ClickOnWhereTo=By.xpath("//android.widget.TextView[@text='Where to?']");
    public static By ClickOnCheckBox=By.xpath("(//android.view.View[@content-desc=\"icon\"])[3]");
    public static By ClickOnSkip=By.xpath("//android.widget.TextView[@text='Skip']");
    public static By selectCatagory=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[2]");
    public static By reviewAndSend=By.xpath("//android.widget.TextView[@text='Review and send']");
    public static By ClickOnSendNow=By.xpath("//android.widget.TextView[@text='Send now']");

    public static By ClickOnbills=By.xpath("//android.widget.TextView[@text='Bills']");

    public static By click_on_pay_a_bill=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.view.View/android.widget.Button");

    public static By enter_amount=By.xpath("(//android.widget.EditText)[2]");

    public static By threedots=By.xpath("(//android.widget.Button)[2]");

    public static By mobile_button_text(String text){
        return By.xpath("//android.widget.TextView[@text='"+text+"']");
    }

    public static By profile_button=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");

}
