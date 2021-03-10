package com.example.hello.controller;

import com.example.hello.config.HttpClientConfig;
import com.example.hello.config.RestTemplateConfig;
import com.example.hello.model.Employee;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestTemplateConfig.class, HttpClientConfig.class })
@Controller
public class EmployeeController {

	@GetMapping("/hello2Employees")
	public String gethello2Employees(Model model) {
		final String uri = "https://hello-to-service.herokuapp.com/api/v1/employees";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		model.addAttribute("employee",result);
		return "employeeAll";
	}

	@GetMapping("/hello2EmployeesById")
	public String gethello2EmployeesById(Model model) {
		final String uri = "https://hello-to-service.herokuapp.com/api/v1/employees/1";
		RestTemplate restTemplate = new RestTemplate();
		String jsonResult = restTemplate.getForObject(uri, String.class);
		Employee employee = new Gson().fromJson(jsonResult, Employee.class);

		if (employee != null){
			model.addAttribute("employee",employee);
		}else{
			model.addAttribute("employee","No Data");
		}

		return "employee";
	}

}