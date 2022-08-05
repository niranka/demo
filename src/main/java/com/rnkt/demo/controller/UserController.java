package com.rnkt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rnkt.demo.dto.UserDto;
import com.rnkt.demo.services.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController {

	@Autowired
	private UserService userService;

	// create user
	@PostMapping("/create")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		try {
			return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// get list of users
	@GetMapping("/userlist")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		try {
			List<UserDto> userDtos = userService.getAllUsers();
			if (userDtos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			else {
				return new ResponseEntity<>(userDtos, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// update user 
	@PutMapping("/edit/{userId}")
	public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
		try {
		return new ResponseEntity<>(userService.editUser(userDto, userId), HttpStatus.OK);				
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// delete users
	@DeleteMapping("/deleteall")
	public ResponseEntity<HttpStatus> deleteUser() {
		userService.deleteAllUser();		
		return new ResponseEntity<HttpStatus>(HttpStatus.GONE);
	}	
	
	// delete user by id
		@DeleteMapping("/delete/{userId}")
		public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId) {
			userService.deleteUserById(userId);
			return new ResponseEntity<>(HttpStatus.GONE);
		}
}
