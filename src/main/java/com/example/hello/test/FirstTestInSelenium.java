package com.example.hello.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestInSelenium {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.out.println("xxxxxxxxxx 1");
//setting the driver executable
        //System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\example\\hello\\test\\chromedriver.exe");
        System.out.println("xxxxxxxxxx 2");
//Initiating your chromedriver
        WebDriver driver=new ChromeDriver();
        System.out.println("xxxxxxxxxx 3");
//Applied wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("xxxxxxxxxx 4");
//maximize window
        driver.manage().window().maximize();
        System.out.println("xxxxxxxxxx 5");
//open browser with desried URL
        driver.get("https://www.yahoo.com");
        System.out.println("xxxxxxxxxx 6");
//closing the browser
        driver.close();
        System.out.println("xxxxxxxxxx 7");

    }

}