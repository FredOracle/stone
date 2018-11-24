package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	public UserDetails loadUserByUsername(String username);
}
