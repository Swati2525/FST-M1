package SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void TestCase2() {
        // Check the URL of the page
        String URL = driver.getCurrentUrl();
        //Print the URL of the page
        System.out.println("Page title is: " + URL);
        //Assertion for page URL
        Assert.assertEquals("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login", URL);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
