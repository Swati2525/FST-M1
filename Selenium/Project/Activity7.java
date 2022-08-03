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

public class Activity7 {
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
    public void TestCase7() throws InterruptedException {
        // Enter Username Password and login
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        boolean HomepageStatus = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).isDisplayed();
        //Assertion for Home page
        Assert.assertTrue(HomepageStatus);
        Thread.sleep(5000);
        // Click MyInfo Option
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]"))));
        driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]")).click();
        //Click Qualification option
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@href, 'Qualifications')]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@href, 'Qualifications')]"))));
        driver.findElement(By.xpath("//a[contains(@href, 'Qualifications')]")).click();
        //Click Add button
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"addWorkExperience\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"addWorkExperience\"]"))));
        driver.findElement(By.xpath("//input[@id=\"addWorkExperience\"]")).click();
        //Fill details
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"experience_employer\"]"))));
        driver.findElement(By.xpath("//input[@id=\"experience_employer\"]")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@id=\"experience_jobtitle\"]")).sendKeys("Test Analyst");
        //Click on save
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"btnWorkExpSave\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"btnWorkExpSave\"]"))));
        driver.findElement(By.xpath("//input[@id=\"btnWorkExpSave\"]")).click();
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
