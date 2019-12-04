package com.example.demo.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
//@PreAuthorize("hasRole('ADMIN')")
public class UserController {
	
//	@Resource
//	private UserRepository repository;
//	
//	@RequestMapping(method = RequestMethod.GET)
//    public List<User> getUsers() {
//        return (List<User>) repository.findAll();
//    }

}
