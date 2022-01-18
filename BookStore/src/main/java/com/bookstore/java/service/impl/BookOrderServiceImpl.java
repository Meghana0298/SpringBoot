package com.bookstore.java.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.java.dto.OrderRequestDto;
import com.bookstore.java.entity.Book;
import com.bookstore.java.entity.BookOrder;
import com.bookstore.java.entity.User;
import com.bookstore.java.exception.BookNotFoundException;
import com.bookstore.java.repository.BookOrderRepository;
import com.bookstore.java.repository.BookRepository;
import com.bookstore.java.repository.UserRepository;
import com.bookstore.java.service.BookOrderService;

@Service
public class BookOrderServiceImpl implements BookOrderService {

	@Autowired
	BookOrderRepository bookOrderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    BookRepository bookRepository;
	
	Double totalPrice;
	
	@Override
	public String saveOrderDetails(OrderRequestDto orderRequestDto) {
		// TODO Auto-generated method stub
		BookOrder bookOrder = new BookOrder();
		Book book = new Book();
		Optional<Book> optionalBook = bookRepository.findById(orderRequestDto.getBookId());
		if(optionalBook.isPresent()) {
			book = optionalBook.get();
			bookOrder.setBook(book);
			bookOrder.setQuanity(orderRequestDto.getQuantity());
			totalPrice = book.getPrice() * bookOrder.getQuanity();
			bookOrder.setTotalPrice(totalPrice);
			bookOrder.setDate(LocalDateTime.now());
			bookOrderRepository.save(bookOrder);
		} 
		else {
			throw new BookNotFoundException("Book not Found");
		}
		
		Optional<User> optionalUser = userRepository.findById(orderRequestDto.getUserId());
		if(optionalUser.isPresent()) {
			User user = new User();
			user = optionalUser.get();
			bookOrder.setUser(user);
			bookOrderRepository.save(bookOrder);
		}
		System.out.println(bookOrder);
		return "Order Placed successfully "+ bookOrder.getTotalPrice();
	}

}
