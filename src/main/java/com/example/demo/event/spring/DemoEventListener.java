package com.example.demo.event.spring;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.demo.rabbitmq.RabbitSender;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DemoEventListener implements ApplicationListener<ApplicationEvent> {

	@Resource
	private RabbitSender sender;
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof CreatedEvent){
			sender.sendMessage(((CreatedEvent)event).getMessage());
			log.info("=============rabbitMQ send message");
			System.out.println(((CreatedEvent)event).getType() + "     :::::" + ((CreatedEvent)event).getMessage());
		}
		
		if(event instanceof UpdatedEvent){
			sender.sendMessage(((UpdatedEvent)event).getMessage());
			log.info("=============rabbitMQ send message");
			System.out.println(((UpdatedEvent)event).getType() + "     :::::" + ((UpdatedEvent)event).getMessage());
		}
		
	}

}
