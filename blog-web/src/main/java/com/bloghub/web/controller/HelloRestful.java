package com.bloghub.web.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

@RestController
public class HelloRestful {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/helloMap")
	public Map<String, String> helloMap() {
		Map<String, String> map = Maps.newHashMap();
		map.put("name", "cys");
		map.put("word", "hello");
		return map;
	}
}
