package com.bookstore.java.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.java.dto.BookResponseProj;
import com.bookstore.java.entity.Book;
import com.bookstore.java.entity.BookOrder;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	List<BookResponseProj> findByBookNameContaining(String foodName);

	List<BookResponseProj> findByGenre(String genre);

	void save(BookOrder bookOrder);

}
