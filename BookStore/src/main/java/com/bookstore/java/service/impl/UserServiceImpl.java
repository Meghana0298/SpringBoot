package com.bookstore.java.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.java.dto.UserRequestDto;
import com.bookstore.java.dto.UserResponseDto;
import com.bookstore.java.entity.User;
import com.bookstore.java.exception.InvalidPasswordException;
import com.bookstore.java.exception.UserNotFoundException;
import com.bookstore.java.repository.UserRepository;
import com.bookstore.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponseDto login(UserRequestDto userRequestDto) {

		User user = userRepository.findByUserName(userRequestDto.getUsername());

		if (user == null) {
			throw new UserNotFoundException("username not found. please enter valid username");
		}
		if (!user.getPassword().equals(userRequestDto.getPassword())) {
			throw new InvalidPasswordException("password does not match, please enter valid password");
		}
		return new UserResponseDto(user.getUserId(), 200, "You have logged in Successfully");
	}

}
