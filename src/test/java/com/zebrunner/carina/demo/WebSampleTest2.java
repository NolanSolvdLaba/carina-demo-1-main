package com.zebrunner.carina.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebSampleTest2 {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Nolan/chromedriver_win32/chromedriver.exe");

        // Create ChromeOptions and set any desired options
        ChromeOptions options = new ChromeOptions();

        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver(options);

        // Open the lingq.com web page
        driver.get("http://the-internet.herokuapp.com/");

        // Verify if the page title is correct
        String expectedTitle = "LingQ - Learn Languages";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page opened successfully!");
        } else {
            System.out.println("Failed to open the page.");
        }

        // Close the browser
        driver.quit();
    }
}
