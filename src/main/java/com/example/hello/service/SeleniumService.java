package com.example.hello.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class SeleniumService {

    public static void robot(){
        try{
            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("currentPath : "+currentPath);
            System.out.println("========================================================================");

            File directoryPath = new File(currentPath);
            //List of all files and directories
            String contents[] = directoryPath.list();
            System.out.println("List of files and directories in the specified directory:");
            for(int i=0; i<contents.length; i++) {
                System.out.println(contents[i]);
            }

            String path = currentPath+"/chromedriver";
            System.out.println("path : "+path);
            System.out.println("path : "+path);
            System.out.println("path : "+path);
            System.out.println("path : "+path);


            File file = new File(path);
            if (file.exists()){
                System.out.println("=================> file.exists() file.exists()");
                System.out.println("=================> file.exists() file.exists()");
                System.out.println("=================> file.exists() file.exists()");
                System.out.println("=================> file.exists() file.exists()");

            }else{
                System.out.println("=================> Not file.exists() Not file.exists()");
                System.out.println("=================> Not file.exists() Not file.exists()");
                System.out.println("=================> Not file.exists() Not file.exists()");
                System.out.println("=================> Not file.exists() Not file.exists()");
                System.out.println("=================> Not file.exists() Not file.exists()");

            }
            System.setProperty("webdriver.chrome.driver","chromedriver");
            WebDriver driver = new ChromeDriver();

            String baseUrl = "http://demo.guru99.com/test/newtours/";
            String expectedTitle = "Welcome: Mercury Tours";
            String actualTitle = "";

            // launch Fire fox and direct it to the Base URL
            driver.get(baseUrl);

            // get the actual value of the title
            actualTitle = driver.getTitle();

            /*
             * compare the actual title of the page with the expected one and print
             * the result as "Passed" or "Failed"
             */
            if (actualTitle.contentEquals(expectedTitle)){
                System.out.println("Test Passed!");
            } else {
                System.out.println("Test Failed");
            }

            //close Fire fox
            driver.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
