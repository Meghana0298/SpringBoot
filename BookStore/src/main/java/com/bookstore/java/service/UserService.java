package com.bookstore.java.service;

import com.bookstore.java.dto.UserRequestDto;
import com.bookstore.java.dto.UserResponseDto;

public interface UserService {

	public UserResponseDto login(UserRequestDto RequestDto);
}
