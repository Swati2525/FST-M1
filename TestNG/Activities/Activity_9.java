package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity_9 {
    WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }
    @BeforeMethod

    @Test
    public void simpleAlertTestCase() {
        // Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);
        // log in
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String msg = driver.findElement(By.xpath("//div[@id=\"action-confirmation\"]")).getText();
        //Assertion for page title
        Assert.assertEquals("Welcome Back, admin", msg);
    }

    @Test
    public void confirmAlertTestCase() {

    }

    @Test
    public void promptAlertTestCase() {
        
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
