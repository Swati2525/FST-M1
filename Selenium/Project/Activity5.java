package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
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
    public void TestCase5() throws InterruptedException {
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
        // Click Edit button
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"btnSave\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"btnSave\"]"))));
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
        //Fill details
        Select seObject = new Select(driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"))));
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).sendKeys("TestLubhani");
        driver.findElement(By.xpath("//input[@id=\"personal_txtEmpLastName\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"personal_txtEmpLastName\"]")).sendKeys("Sharma");
        driver.findElement(By.xpath("//input[@id=\"personal_optGender_2\"]")).click();
        seObject.selectByValue("82");
        // Click on save
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"btnSave\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"btnSave\"]"))));
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
        // Assert edited value
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]"))));
        String upddatedName = driver.findElement(By.xpath("//input[@id=\"personal_txtEmpFirstName\"]")).getAttribute("value");
        Assert.assertEquals("TestLubhani",upddatedName);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
         driver.quit();
    }

}
