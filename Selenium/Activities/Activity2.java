package FST20_SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Firefox object
        WebDriver driver = new FirefoxDriver();
        // open browser
        driver.get("https://www.training-support.net/");
        // get and print title
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        // close browser
        driver.close();
    }
}
