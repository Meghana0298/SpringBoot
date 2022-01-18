package com.bookstore.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.java.dto.BookRequestDto;
import com.bookstore.java.dto.BookResponseDto;
import com.bookstore.java.dto.BookResponseProj;
import com.bookstore.java.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/books")
	public String addBook(@RequestBody BookRequestDto bookRequestDto) {
		bookService.addBook(bookRequestDto);
		return "Book Data saved successfully";
	}

	@GetMapping("/books")
	public List<BookResponseDto> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/books/{bookId}")
	public BookResponseDto getBookById(@PathVariable Integer bookId) {
		return bookService.getBookById(bookId);
	}

	@GetMapping("/books/bookname")
	public ResponseEntity<List<BookResponseProj>> getBookItemByName(@RequestParam String bookName) {
		return new ResponseEntity<List<BookResponseProj>>(bookService.getBookByName(bookName), HttpStatus.ACCEPTED);
	}

	@GetMapping("/books/bookgenre")
	public ResponseEntity<List<BookResponseProj>> getBookItemByGenre(@RequestParam String genre) {
		return new ResponseEntity<List<BookResponseProj>>(bookService.findByGenre(genre), HttpStatus.ACCEPTED);
	}

	@PutMapping(value = "/books/{bookId}")
	public String updateBook(@RequestBody BookRequestDto BookRequestDto, @PathVariable Integer bookId) {
		bookService.updateBook(BookRequestDto, bookId);
		return "book data updated successfully";
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable Integer bookId){
		bookService.deleteBook(bookId);
		return new ResponseEntity<String>("book deleted successfully",HttpStatus.OK);
	}
}
