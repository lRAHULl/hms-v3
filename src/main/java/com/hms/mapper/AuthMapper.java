package com.hms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

	@Select("SELECT password FROM t_user WHERE username=#{username}")
	String login(String username);

}
