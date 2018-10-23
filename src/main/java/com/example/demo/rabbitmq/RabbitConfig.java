package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



@Configuration
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitConfig {
	
	//rabbitmq connection info
	private String host;
	private int port;
	private String username;
	private String password;
	
	
	
	private final static String Queue_Hello = "Hello";
	
	
	@Bean
	public CachingConnectionFactory connectionFactory(){
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost("/");
		connectionFactory.setPublisherConfirms(true);
		return connectionFactory;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplate(){
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		return template;
	}
	
	@Bean
	public Queue queue(){
		return new Queue(Queue_Hello);
	}
	
	
	
	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
	

}
