package com.bookstore.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.java.dto.BookRequestDto;
import com.bookstore.java.dto.BookResponseDto;
import com.bookstore.java.dto.BookResponseProj;
import com.bookstore.java.entity.Book;
import com.bookstore.java.exception.BookNotFoundException;
import com.bookstore.java.repository.BookRepository;
import com.bookstore.java.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public void addBook(BookRequestDto bookRequestDto) {

		Book book = new Book();
		BeanUtils.copyProperties(bookRequestDto, book);
		bookRepository.save(book);
	}

	@Override
	public List<BookResponseDto> getAllBooks() {
		List<BookResponseDto> bookReponseList = new ArrayList<>();
		Iterator it = bookRepository.findAll().iterator();
		while (it.hasNext()) {
			BookResponseDto responseDto = new BookResponseDto();
			BeanUtils.copyProperties(it.next(), responseDto);
			bookReponseList.add(responseDto);
		}
		return bookReponseList;
	}

	@Override
	public BookResponseDto getBookById(Integer bookId) {
		Book book = new Book();
		BookResponseDto bookResponseDto = new BookResponseDto();
		Optional<Book> optionalBook = bookRepository.findById(bookId);

		if (optionalBook.isPresent())
			book = optionalBook.get();

		BeanUtils.copyProperties(book, bookResponseDto);
		return bookResponseDto;
	}

	@Override
	public List<BookResponseProj> getBookByName(String bookName) {
		List<BookResponseProj> bookResponseProjList = bookRepository.findByBookNameContaining(bookName);
		if (bookResponseProjList.isEmpty())
			throw new BookNotFoundException("no book present with given name: " + bookName);
		return bookResponseProjList;
	}
	

	@Override
	public List<BookResponseProj> findByGenre(String genre) {
		List<BookResponseProj> bookResponseProjList = bookRepository.findByGenre(genre);
		if (bookResponseProjList.isEmpty())
			throw new BookNotFoundException("no book present with given genre: " + genre);
		return bookResponseProjList;
	}

	@Override
	public void updateBook(BookRequestDto bookRequestDto, Integer bookId) {

		Book book = bookRepository.findById(bookId).get();
		BeanUtils.copyProperties(bookRequestDto, book);
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		Optional<Book> optionalBook = bookRepository.findById(bookId);

		if (optionalBook.isPresent()) {
            Book book = new Book();
			book = optionalBook.get();
			book.setBookId(bookId);
			bookRepository.delete(book);
		} else {
			throw new BookNotFoundException("Book not found for given Id");
		}
	}
}
