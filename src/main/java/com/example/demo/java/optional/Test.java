package com.example.demo.java.optional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map();
	}
	
	
	static void map(){
		List<Role> roles = Collections.emptyList();
		Role role = Role.builder().id(UUID.randomUUID().toString()).roleName("A").build();
		roles.add(role);
		role = Role.builder().id(UUID.randomUUID().toString()).roleName("B").build();
		roles.add(role);
		role = Role.builder().id(UUID.randomUUID().toString()).roleName("C").build();
		roles.add(role);
		role = Role.builder().id(UUID.randomUUID().toString()).roleName("D").build();
		roles.add(role);
		
		User user = User.builder().username("Fred").createtime(new Date()).id(UUID.randomUUID().toString()).password(UUID.randomUUID().toString()).updatetime(new Date()).roles(roles).build();
		Optional<User> op = Optional.of(user);
		System.out.println( op.map(u -> u.getUsername()).map(name -> name.toUpperCase()));
	}

}
