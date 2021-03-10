package com.example.hello.controller;

import com.example.hello.config.HttpClientConfig;
import com.example.hello.config.RestTemplateConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestTemplateConfig.class, HttpClientConfig.class })
@Controller
public class HelloController {

	//@GetMapping("/login")
	//public String getlogin(Model model) {
	//	return "login";
	//}
	
	@PostMapping("/login")
	public String postBody(@RequestBody String userName,String password) {
		model.addAttribute("hello","Hello Khun "+userName+" ");
		return "hello";
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
}
