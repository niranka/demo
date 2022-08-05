package com.rnkt.demo.services;

import java.util.List;

import com.rnkt.demo.dto.UserDto;

public interface UserService {
	
	UserDto addUser(UserDto userDto);
	
	List<UserDto> getAllUsers();
	
//	UserDto getUserByEmail(String email);
//	
//	UserDto getUsrByUserName(String userName);
	
	UserDto editUser(UserDto userDto, Integer userId);
	
	void deleteAllUser();
	
	void deleteUserById(Integer userId);
	

}
