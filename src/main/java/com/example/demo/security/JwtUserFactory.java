package com.example.demo.security;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

//	public static JwtUser create(User user) {
//		return new JwtUser(user.getId(), user.getUsername(), user.getPassword(), user.getCreatetime(),
//				user.getUpdatetime(), mapToGrantedAuthorities(user.getRoles().stream().map(role->role.getRoleName()).collect(Collectors.toList())));
//	}
//
//	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
//		return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//	}

}
