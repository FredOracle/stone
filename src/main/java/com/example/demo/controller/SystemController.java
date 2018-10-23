package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Controller
public class SystemController {
	 
	@RequestMapping(value="/weblcome", method=RequestMethod.GET)
	public String welcome(){
		System.out.println("===============");
		return "welcome";
	}
	
	
}
