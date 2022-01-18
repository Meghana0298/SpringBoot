package com.bookstore.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.java.dto.OrderRequestDto;
import com.bookstore.java.service.BookOrderService;

@RestController
public class BookOrderController {

	@Autowired
	BookOrderService bookOrderService;
	
	@PostMapping("/bookOrders")
	public ResponseEntity<String> saveOrderDetails(@RequestBody OrderRequestDto orderRequestDto){
		return new ResponseEntity<String>(bookOrderService.saveOrderDetails(orderRequestDto),HttpStatus.ACCEPTED);
	}
}
