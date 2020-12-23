package com.example.demo.event.spring;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

  @Resource
  private ApplicationContext applicationContext;

  public void createdPush(CreatedEvent event) {
    applicationContext.publishEvent(event);
  }

  public void updatedPush(UpdatedEvent event) {
    applicationContext.publishEvent(event);
  }
}
