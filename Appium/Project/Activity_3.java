package Appium_Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity_3 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumFST20");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 500);
    }

    @Test
    public void TestGoogleKeepReminder() {
        // Click new note
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.keep:id/new_note_button")));
        driver.findElementById("com.google.android.keep:id/new_note_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.keep:id/editable_title")));
        // Add Title and note
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Google Keep");
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Test Notes");
        //add reminder
        driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();
        driver.findElementByXPath("//android.widget.TextView[@text= 'Later today']").click();
        // click Back button
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        // Assertion
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.keep:id/reminder_chip_text")));
        String reminder  = driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
        Assert.assertEquals(reminder, "Today, 6:00 PM");
    }

    @AfterClass
    public void tearDown() {
        // Close app
       // driver.quit();
    }

}
