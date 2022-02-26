package com.example.hello.controller;

import com.example.hello.config.HttpClientConfig;
import com.example.hello.config.RestTemplateConfig;
import com.example.hello.service.JavaRunCommand;
import com.example.hello.service.SeleniumService;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestTemplateConfig.class, HttpClientConfig.class })
@Controller
public class SeleniumController {



	@GetMapping("/CheckTitle")
	public String CheckTitle(Model model) {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\example\\hello\\test\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

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
		StringBuffer resultTest=new StringBuffer();
		resultTest.append("expected : "+expectedTitle);
		resultTest.append("<br>");
		resultTest.append("actual : "+actualTitle);
		resultTest.append("<br>");

		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test Passed!");
			resultTest.append("result : Test Passed!");
		} else {
			System.out.println("Test Failed");
			resultTest.append("result : Test Failed!");
		}

		//close Chrome
		driver.close();

		model.addAttribute("hello",resultTest);
		return "selenium_result";
	}
}
