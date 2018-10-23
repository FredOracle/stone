package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RabbitListener(queues = "Hello")  
public class RabbitReceiver {

	@RabbitHandler
	public void receiverMessage(String message){
		log.info("Receiver::::::::::::" + message);
	}
	
	
}
