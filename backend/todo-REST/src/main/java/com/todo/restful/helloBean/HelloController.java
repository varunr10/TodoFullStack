package com.todo.restful.helloBean;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloController {

	
	@GetMapping(path="/hello-world")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloBean getHelloWorldBean() {
		//throw new RuntimeException("Error Occurred- Contact Todo Application Support");
		return new HelloBean("Good Morning To-Do user");
	}
	
	@GetMapping(path="/hello-world-bean/{name}")
	public HelloBean getHelloWorldBean1(@PathVariable String name) {
		return new HelloBean("Hey "+name+" bruvvv, What's up ? :D How is it going nigga? ");
	}
}