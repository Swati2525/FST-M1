package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Open browser
        driver.get("https://training-support.net/selenium/ajax");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // Click the change content button
        driver.findElement(By.xpath("//button[contains(@class, 'violet')]")).click();
        // wait till "Hello" text
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
        String MessageText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("Message: "+ MessageText);
        // Wait till "I am Late" text and print it
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        MessageText = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("Late Message: "+ MessageText);
        //Close the browser
        driver.close();


    }
}
