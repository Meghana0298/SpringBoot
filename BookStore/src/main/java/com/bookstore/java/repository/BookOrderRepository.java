package com.bookstore.java.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.java.entity.BookOrder;

@Repository
public interface BookOrderRepository extends CrudRepository<BookOrder,Integer>{

	

}
