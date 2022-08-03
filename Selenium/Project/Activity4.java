package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void TestCase4() throws InterruptedException {
        // Enter Username Password and login
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        boolean HomepageStatus = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).isDisplayed();
        //Assertion for Home page
        Assert.assertTrue(HomepageStatus);
        Thread.sleep(5000);
        // Click PIM Option
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]"))));
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
        // Click add button
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"))));
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]")).click();
        // Fill in the required fields and click Save
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"firstName\"]"))));
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Lubhani");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Sharma");
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"))));
        String AddedName = driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).getAttribute("value");
        //Assertion for AddedName
        Assert.assertEquals("Lubhani",AddedName);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
