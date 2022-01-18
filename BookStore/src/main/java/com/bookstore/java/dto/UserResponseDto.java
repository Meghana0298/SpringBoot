package com.bookstore.java.dto;

public class UserResponseDto {

	private Integer userId;
	private int status;
	private String message;

	public UserResponseDto(Integer userId, int status, String message) {
        this.userId = userId;
		this.status = status;
		this.message = message;
	}

	public Integer getUserId() {
		return userId;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
