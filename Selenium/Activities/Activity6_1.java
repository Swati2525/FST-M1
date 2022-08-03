package FST20_SeleniumProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // Click the "Remove Checkbox"
        driver.findElement(By.id("toggleCheckbox")).click();
        // wait till the checkbox disappears
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//input[@class = 'willDisappear']"))));
        // Click the "Remove Checkbox" again
        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class = 'willDisappear']"))));
        // click checkbox
        driver.findElement(By.xpath("//input[@class = 'willDisappear']")).click();
        //Close the browser
        driver.close();


    }
}
