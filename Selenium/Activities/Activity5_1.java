package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // check for checkbox
        if (driver.findElement(By.xpath("//input[@class = 'willDisappear']")).isDisplayed()) {
            System.out.println("Dynamic Checkbox is displayed");
            // Click the "Remove Checkbox"
            driver.findElement(By.id("toggleCheckbox")).click();
            System.out.println("Clicked Remove Checkbox");
            if (driver.findElement(By.xpath("//input[@class = 'willDisappear']")).isDisplayed()) {
                System.out.println("Dynamic Checkbox still displayed");
            }
            else{
                System.out.println("Dynamic Checkbox is not displayed");
                }
        }
        //Close the browser
        driver.close();
    }
}
