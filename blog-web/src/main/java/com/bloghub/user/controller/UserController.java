package com.bloghub.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.bloghub.user.entity.User;
import com.bloghub.user.mapper.UserMapper;

@RestController
@RequestMapping({"/user"})
public class UserController {
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value = "/{userCode}" , method = RequestMethod.GET)
	public String user(@PathVariable String userCode){
		System.out.println(userCode);
		User user = userMapper.findUserByCode(userCode);
		return user.getName()+"-----"+user.getEmail();
	}

	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam String userCode, @RequestParam String userPwd){
		System.out.println(userCode);
		User user = userMapper.findUserByCode(userCode);
		Map map = new HashMap<>();
		map.put("userCode", user.getCode());
		map.put("userName", user.getName());
		map.put("email", user.getEmail());
		if(user.getPassword().equals(userPwd)){
			String ret = JSONUtils.toJSONString(map); 
			return ret;
		}
		else{
			return "";
		}
	}
}
