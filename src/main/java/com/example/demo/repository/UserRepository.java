package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.User;

public interface UserRepository extends CrudRepository<User, String> {

	public User findByUsername(String username);
}
