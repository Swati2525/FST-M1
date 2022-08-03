package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
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
    public void TestCase8() throws InterruptedException {
        // Enter Username Password and login
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        boolean HomepageStatus = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).isDisplayed();
        //Assertion for Home page
        Assert.assertTrue(HomepageStatus);
        // Click apply leave Option
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@href, 'applyLeave') and (@target = '_self')]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(@href, 'applyLeave') and (@target = '_self')]"))));
        boolean status = driver.findElement(By.xpath("//a[contains(@href, 'applyLeave') and (@target = '_self')]")).isEnabled();
        if (status) {
            driver.findElement(By.xpath("//a[contains(@href, 'applyLeave') and (@target = '_self')]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        }
        //Fill the details
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id=\"applyleave_txtLeaveType\"]"))));
        driver.findElement(By.xpath("//input[@id=\"applyleave_txtFromDate\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"applyleave_txtFromDate\"]")).sendKeys("2022-02-24");
        driver.findElement(By.xpath("//input[@id=\"applyleave_txtToDate\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"applyleave_txtToDate\"]")).sendKeys("2022-02-24");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Select seObject = new Select(driver.findElement(By.xpath("//select[@id=\"applyleave_txtLeaveType\"]")));
        seObject.selectByValue("6");
        driver.findElement(By.xpath("//*[@id=\"applyleave_txtComment\"]")).sendKeys("Leave");
        //Click apply button
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"applyBtn\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"applyBtn\"]"))));
        driver.findElement(By.xpath("//input[@id=\"applyBtn\"]")).click();
        // click myLeave link
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id=\"menu_leave_viewMyLeaveList\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id=\"menu_leave_viewMyLeaveList\"]"))));
        driver.findElement(By.xpath("//a[@id=\"menu_leave_viewMyLeaveList\"]")).click();
        //set detals and search
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"calFromDate\"]"))));
        driver.findElement(By.xpath("//input[@id=\"calFromDate\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"calFromDate\"]")).sendKeys("2022-02-24");
        driver.findElement(By.xpath("//input[@id=\"calToDate\"]")).clear();
        driver.findElement(By.xpath("//input[@id=\"calToDate\"]")).sendKeys("2022-02-24");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id=\"btnSearch\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"btnSearch\"]"))));
        driver.findElement(By.xpath("//input[@id=\"btnSearch\"]")).click();
        //Cell value of leave status
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id=\"resultTable\"]"))));
        WebElement Leave_status = driver.findElement(By.xpath("//table[@id=\"resultTable\"]/tbody/tr[1]/td[6]"));
        String leaveStatus = Leave_status.getText();
        // Assert Leave status
        Assert.assertEquals("Pending Approval(1.00)",leaveStatus);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
