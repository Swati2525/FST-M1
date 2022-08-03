package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // check for checkbox
        Boolean Checkbox_status = (driver.findElement(By.xpath("//input[@class = 'willDisappear']")).isSelected());
        System.out.println("Dynamic Checkbox is selected: " + Checkbox_status);
        // set checkbox"
        driver.findElement(By.xpath("//input[@class = 'willDisappear']")).click();
        Checkbox_status = (driver.findElement(By.xpath("//input[@class = 'willDisappear']")).isSelected());
        System.out.println("Dynamic Checkbox is selected: " + Checkbox_status);

        //Close the browser
        driver.close();

    }
}
