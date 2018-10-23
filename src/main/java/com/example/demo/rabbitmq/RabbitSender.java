package com.example.demo.rabbitmq;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitSender {
	
	@Resource
	private RabbitTemplate template;
	
	public void sendMessage(String message){
		template.convertAndSend("Hello", message);
		log.info("Sender:::::::::::::::::" + message);
	}

}
