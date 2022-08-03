package FST20_SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        // create firefox object
            WebDriver driver = new FirefoxDriver();
        // Open a browser
            driver.get("https://www.training-support.net/");
       // Close the browser
            driver.close();
    }
}
