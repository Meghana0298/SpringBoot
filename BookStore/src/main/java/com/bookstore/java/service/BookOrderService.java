package com.bookstore.java.service;

import com.bookstore.java.dto.OrderRequestDto;

public interface BookOrderService {

	String saveOrderDetails(OrderRequestDto orderRequestDto);

}
