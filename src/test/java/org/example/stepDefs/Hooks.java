package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver=null;

    @Before
    public static void openBrowser()
    {
        //1-Bridge
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");

        //2-create new object from chromedriver
        driver = new ChromeDriver();

        //3-configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4-Navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
       driver.quit();
    }
}
