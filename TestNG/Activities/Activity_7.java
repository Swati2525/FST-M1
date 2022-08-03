package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity_7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "password" }};
    }

    @Test(dataProvider = "Authentication")
    public void loginTestCase(String username, String password) {
        //Find username and pasword fields
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Click Log in
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();

        //Assert Message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void afterClass() {
        //Close browser
       // driver.close();
    }
}
