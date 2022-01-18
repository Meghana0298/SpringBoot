package com.bookstore.java.service;

import java.util.List;

import com.bookstore.java.dto.BookRequestDto;
import com.bookstore.java.dto.BookResponseDto;
import com.bookstore.java.dto.BookResponseProj;

public interface BookService {

	void addBook(BookRequestDto bookRequestDto);

	List<BookResponseDto> getAllBooks();

	BookResponseDto getBookById(Integer bookId);

	List<BookResponseProj> getBookByName(String bookName);

	List<BookResponseProj> findByGenre(String genre);

	void updateBook(BookRequestDto bookRequestDto, Integer bookId);

	void deleteBook(Integer bookId);

}
