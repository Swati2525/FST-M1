package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // check for input box
        Boolean Editbox_status = (driver.findElement(By.xpath("//input[@id= 'input-text']")).isEnabled());
        System.out.println("Input box is enabled:  " + Editbox_status);
        // click Enable input button
        driver.findElement(By.id("toggleInput")).click();
        Editbox_status = (driver.findElement(By.xpath("//input[@id= 'input-text']")).isEnabled());
        System.out.println("Input box is enabled: " + Editbox_status);

        //Close the browser
        driver.close();

    }
}
