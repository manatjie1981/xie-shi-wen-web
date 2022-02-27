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

import java.io.File;
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
		setPermissionFile("//app");

		showPermissionFile("//app");
		//showPermissionFile("//app//src//main//java//com//example//hello//test//");
		commandLine("ls -l");
		System.out.println("xxxxxxxxxx 1");
//setting the driver executable
		//System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "//app//src//main//java//com//example//hello//test//chromedriver2.exe");
		System.setProperty("webdriver.chrome.driver", "//app//chromedriver.exe");

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
		return "AutoTest";
	}

	private void setPermissionFile(String path){
		try{
			Process process = Runtime.getRuntime().exec("chmod 777 *");
		}catch (Exception e){
			e.printStackTrace();
		}
/*		File f = new File(path);
		String[] pathnames = f.list();
		for (String pathname : pathnames) {
			// Print the names of files and directories
			File file = new File(pathname);
			file.setReadable(true, false);
			file.setExecutable(true, false);
			file.setWritable(true, false);
		}*/
	}

	private void showPermissionFile(String path){
		File f = new File(path);
		if (f.exists())
			System.out.println("Exists");
		else
			System.out.println("Does not Exists");
		String[] pathnames;
		pathnames = f.list();

		// For each pathname in the pathnames array
		for (String pathname : pathnames) {
			// Print the names of files and directories
			System.out.println(pathname);
			File file = new File(pathname);
			if(file.canWrite()) {
				System.out.println(pathname+" : canWrite");
			} else if (file.canExecute()){
				System.out.println(pathname+" : canExecute");
			}else if (file.canRead()){
				System.out.println(pathname+" : canRead");
			}
		}
	}

	private void commandLine(String cmd){
		try{
			Process process = Runtime.getRuntime().exec(cmd);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
