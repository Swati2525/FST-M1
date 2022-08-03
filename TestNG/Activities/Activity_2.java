package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_2 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void TestCase1() {
        // Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);
        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }
    @Test
    public void TestCase2() {
        WebElement BlackButton =  driver.findElement(By.xpath("//button[contains(@class, 'black button')]"));
        System.out.println("The color of button is: " + BlackButton.getText() );
        Assert.assertEquals(BlackButton.getText(),"Black");
    }
    @Test(enabled = false)
    public void TestCase3() {
        System.out.println("This function is skipped");
    }
    @Test
    public void TestCase4() throws SkipException{
        String Condition = "skip test";
        if (Condition.equals("skip test")){
            throw new SkipException("This test is not ready");
        }

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
       // driver.quit();
    }
}
