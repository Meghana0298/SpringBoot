package com.bookstore.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.java.dto.UserRequestDto;
import com.bookstore.java.dto.UserResponseDto;
import com.bookstore.java.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userRequestDto) {
		UserResponseDto response = userService.login(userRequestDto);
		return new ResponseEntity<UserResponseDto>(response, HttpStatus.ACCEPTED);

	}
}
