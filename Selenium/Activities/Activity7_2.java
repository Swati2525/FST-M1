package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Open browser
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // fill input fields
        driver.findElement(By.cssSelector("input[class $= '-username']")).sendKeys("Lubhani");
        driver.findElement(By.cssSelector("input[class $= '-password']")).sendKeys("password");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input")).sendKeys("password");
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following::input")).sendKeys("Test@gmail.com");
        // click signup
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        String MessageText = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Message: " + MessageText);

        //Close the browser
        driver.close();
    }
}
