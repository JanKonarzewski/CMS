package com.konarzewski.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class ExampleController {

	@RequestMapping("/show")
	public void show() {
		System.out.println("Here it Works");
	}
	
}
