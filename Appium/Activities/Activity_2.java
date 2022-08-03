package Act;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity_2 {
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
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main\"");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 100);
    }

    @Test
    public void Test2() {
        // Open URL
        driver.get("https://www.training-support.net/");
        // Wait for page to load
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("About Us")));
        // getting title
        String title = driver.getTitle();
        System.out.println("The title is: " + title);
        title = driver.findElement(By.xpath("//android.view.View[text() = 'Training Support']")).getText();
        System.out.println("The finaltitle is: " + title);
        // click on About Us button
        driver.findElementById("about-link").click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='About Us']")));
        // getting title
        String Newtitle = driver.getTitle();
        System.out.println("The title is: " + title);
        driver.findElementByXPath("//android.view.View[@text = \"About Us\"]").click();
        Newtitle = driver.findElementByXPath("//android.view.View[text() = 'About Us']").getText();
        System.out.println("The finaltitle is: " + title);

        // Assertion
        Assert.assertEquals(title, "Training Support");
        Assert.assertEquals(Newtitle, "About Us");
    }

    @AfterClass
    public void tearDown() {
        // Close app
        //driver.quit();
    }
}
