package com.example.hello.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class TestSelenium {
    public static <WebDriverWait> void main(String[] args) {
        try {
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\ghs6kor\\Desktop\\Java\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\example\\hello\\test\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("https://www.google.com/");
            // identify element
            WebElement p=driver.findElement(By.name("q"));
            //enter text with sendKeys() then apply submit()
            p.sendKeys("Selenium Java");
            // Explicit wait condition for search results
            Thread.sleep(2000);
            Object ExpectedConditions;
            p.submit();
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
