package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get("https://www.training-support.net/selenium/simple-form");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // get element and set value
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Lubhani");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Sharma");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Lubhani@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"number\"]")).sendKeys("8796785678");

        // submit form
        driver.findElement(By.xpath("//input[contains(@type, 'submit')]")).click();

        //Close the browser
        driver.close();
    }
}
