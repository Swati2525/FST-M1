package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity_5 {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
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
        Assert.assertEquals(title, "Target Practice");
    }
    @Test (groups = {"HeaderTests"})
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        Assert.assertEquals(header3.getText(), "Third header");
    }

    @Test (groups = {"HeaderTests"})
    public void HeaderTest2() {
        WebElement header5 = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        Assert.assertEquals(header5.getCssValue("color"), "rgb(251, 189, 8)");
    }

    @Test (groups = {"ButtonTests"})
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'olive button')]"));
        Assert.assertEquals(button1.getText(), "Olive");
    }

    @Test (groups = {"ButtonTests"})
    public void ButtonTest2() {
        WebElement button2 = driver.findElement(By.xpath("//button[contains(@class, 'olive button')]"));
        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
    }

    // After test with always true
    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
       // driver.close();
    }
}
