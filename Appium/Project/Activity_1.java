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

public class Activity_1 {
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
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 500);
    }

    @Test
    public void TestGoogleTask() {
        // Click new task
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        // Add first task and save
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        // Add second task and save
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        // Add third task and save
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
        driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
        // Assertion
        String Task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
        String Task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
        String Task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();
        Assert.assertEquals(Task1, "Complete the second Activity Google Keep");
        Assert.assertEquals(Task2, "Complete Activity with Google Keep");
        Assert.assertEquals(Task3, "Complete Activity with Google Tasks");
    }

    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}
