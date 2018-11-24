package com.example.demo.security;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
	
	@Resource
	private UserRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return (List<User>) repository.findAll();
    }

}
