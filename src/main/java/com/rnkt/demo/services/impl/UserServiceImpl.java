package com.rnkt.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codev.blog.exceptions.ResourceNotFoundException;
import com.rnkt.demo.dto.UserDto;
import com.rnkt.demo.entities.User;
import com.rnkt.demo.repository.UserRepository;
import com.rnkt.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	// convert dto to entity
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user = modelMapper.map(userDto, User.class);
		return user;
	}

	// convert entity to dto
	public UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = dtoToEntity(userDto);
		User savedUser = userRepository.save(user);
		return entityToDto(savedUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(userdata->entityToDto(userdata)).collect(Collectors.toList());
	}

	@Override
	public UserDto editUser(UserDto userDto, Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", "userId"));
		user.setFirst_Name(userDto.getFirst_Name());
		user.setLast_Name(userDto.getLast_Name());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setDob(userDto.getDob());
		user.setGender(userDto.getGender());
		User updatedUser = userRepository.save(user);
		return entityToDto(updatedUser);
	}

	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();;	
	}

	@Override
	public void deleteUserById(Integer userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", "userId"));
		userRepository.delete(user);
	}

}
