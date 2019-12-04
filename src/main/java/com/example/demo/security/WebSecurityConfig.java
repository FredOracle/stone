package com.example.demo.security;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig 
//extends WebSecurityConfigurerAdapter 
{

//	@Resource
//	private UserDetailsService userDetailsService;
//
//	@Resource
//	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////		authenticationManagerBuilder
////		.userDetailsService(this.userDetailsService)
////		.passwordEncoder(passwordEncoder());
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
//				.permitAll().anyRequest().authenticated();
//		httpSecurity.headers().cacheControl();
//	}

}
