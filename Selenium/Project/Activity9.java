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
import java.util.List;

public class Activity9 {
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
    public void TestCase9() throws InterruptedException {
        // Enter Username Password and login
        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("orange");
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        boolean HomepageStatus = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).isDisplayed();
        //Assertion for Home page
        Assert.assertTrue(HomepageStatus);
        // Click MyInfo Option
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]"))));
        driver.findElement(By.xpath("//a[@id=\"menu_pim_viewMyDetails\"]")).click();
        // Click emergency Contacts
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text() = 'Emergency Contacts']"))));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text() = 'Emergency Contacts']"))));
        driver.findElement(By.xpath("//a[text() = 'Emergency Contacts']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        // fetch and print contact details
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"emgcontact_list\"]/tbody/tr"));
        for(int i=1; i<=rows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]"));
            System.out.println("Row " + i + ": " + row.getText());
        }
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
