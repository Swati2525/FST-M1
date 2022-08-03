package FST20_SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Open browser
        driver.get("https://www.training-support.net/selenium/target-practice");
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        // get elements
        String HeaderText = driver.findElement(By.xpath("//h3[@id=\"third-header\"]")).getText();
        System.out.println("Third Header text is: " + HeaderText);
        String HeaderColor = driver.findElement(By.xpath("//h5[contains(@class, 'green header')]")).getCssValue("color");
        System.out.println("Fifth Header color is: " + HeaderColor);
        String ClassAttribute = driver.findElement(By.xpath("//button[contains(@class, 'violet')]")).getAttribute("class");
        System.out.println("Violet button class attribute is: " + ClassAttribute);
        String ButtonText = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("Grey button text is: " + ButtonText);

        //Close the browser
        driver.close();
    }
}
