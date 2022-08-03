package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity_3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get(" https://www.training-support.net/selenium/login-form");
    }

    @Test
    public void TestCase1() {
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

    @AfterClass
    public void afterMethod() {
        //Close the browser
         driver.quit();
    }
}
