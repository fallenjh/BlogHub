package com.bloghub.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bloghub.user.entity.User;

@Mapper
public interface UserMapper {

	@Select("select id, code, name, mobile, email, password from user where code = #{code}")
	User findUserByCode(@Param("code")String code);
}
