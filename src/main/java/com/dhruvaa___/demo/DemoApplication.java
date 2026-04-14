package com.dhruvaa___.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class  DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping
	public String Helloworld()
	{
		return "This is Spring Boot";
	}
	@RequestMapping("/hello")
	public String requestMethodName(@RequestParam(required = false, defaultValue = "Guest") String param) {
    return "Hello, " + param;
}
}

