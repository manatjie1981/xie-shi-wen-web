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
public class HelloController {

	@GetMapping("/login")
	public String getlogin(Model model) {
		return "login";
	}

	@GetMapping("/AutoTest")
	public String getAutoTest(Model model) {
		return "AutoTest";
	}

	@PostMapping("/login")
	public String postBody(Model model, @RequestBody String userName2,String userName,String password) {
		System.out.println("userName2 : "+userName2);
		System.out.println("userName : "+userName);
		System.out.println("password : "+password);

		if ((userName == null || "".equals(userName)) && (password == null || "".equals(password))){
			welcome(model);
		}else{
			model.addAttribute("hello","Hello Khun "+userName+" "+password);
		}

		return "hello";
	}

	@PostMapping("/AutoTest")
	public String AutoTest(Model model, @RequestBody String wordingSearch2, String wordingSearch) {

		System.out.println("wordingSearch2 : "+wordingSearch2);
		System.out.println("wordingSearch : "+wordingSearch);
		String cmd = "cmd.exe /c start robot -v search_wording:"+wordingSearch+" test_script01.txt";
		JavaRunCommand.runCommand(cmd);

		return "AutoTest";
	}
	
	
	@GetMapping("/hello")
	public String getHello(Model model) {
		model.addAttribute("hello","Hello Spring Boot User");
		return "hello";
	}
	
	@GetMapping("/")
	public String welcome(Model model) {
		return "login";
	}

	@GetMapping("/robot")
	public String robot(Model model) {
		SeleniumService.robot();
		model.addAttribute("hello","We can run robot on Spring Boot");
		return "hello";
	}

	@GetMapping("/AutoTest2")
	public String getAutoTest2(Model model) {
		// TODO Auto-generated method stub
		final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);
		System.out.println("xxxxxxxxxx 1");
//setting the driver executable
		//System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "src//main//java//com//example//hello//test//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\example\\hello\\test\\chromedriver.exe");
		System.out.println("xxxxxxxxxx 2");
//Initiating your chromedriver
		WebDriver driver=new ChromeDriver();
		System.out.println("xxxxxxxxxx 3");
//Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("xxxxxxxxxx 	4");
//maximize window
		driver.manage().window().maximize();
		System.out.println("xxxxxxxxxx 5");
//open browser with desried URL
		driver.get("https://www.yahoo.com");
		System.out.println("xxxxxxxxxx 6");
//closing the browser
		driver.close();
		System.out.println("xxxxxxxxxx 7");
		return "AutoTest";
	}
}
