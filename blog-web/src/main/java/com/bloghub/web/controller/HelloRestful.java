package com.bloghub.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestful {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/helloMap")
	public Map<String, String> helloMap(){
		Map<String, String> map = new HashMap();
		map.put("name", "cys");
		map.put("word", "hello");
		return map;
	}
}
