package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
            driver.get("https://www.training-support.net/selenium/simple-form");
        //Find the page title and print it
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle);
        // get element and set value
             driver.findElement(By.id("firstName")).sendKeys("Lubhani");
             driver.findElement(By.id("lastName")).sendKeys("Sharma");
             driver.findElement(By.id("email")).sendKeys("Lubhani@gmail.com");
             driver.findElement(By.id("number")).sendKeys("8796785678");

        // submit form
        driver.findElement(By.cssSelector(".ui.green.button")).click();

        //Close the browser
         driver.close();
    }
}
