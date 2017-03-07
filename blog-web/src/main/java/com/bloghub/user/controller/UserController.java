package com.bloghub.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
