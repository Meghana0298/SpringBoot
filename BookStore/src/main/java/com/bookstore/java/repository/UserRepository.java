package com.bookstore.java.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.java.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUserName(String userName);
}
