package com.bloghub.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

@Controller
public class HelloRestful {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
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

	@RequestMapping(value = "/markdown")
	public String helloMarkdown() {
		return "index";
	}
}
