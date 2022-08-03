package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get("https://www.training-support.net");
        // get page title and print it
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
       // click on about us using x-path
        driver.findElement(By.xpath("//*[@id=\"about-link\"]")).click();
        // get new page title and print it
        String titleNew = driver.getTitle();
        System.out.println("New Page title is: " + titleNew);
        //Close the browser
        driver.close();

    }

}
