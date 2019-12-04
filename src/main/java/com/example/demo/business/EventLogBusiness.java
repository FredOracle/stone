package com.example.demo.business;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.bean.EventLog;
import com.example.demo.repository.EventLogRepository;

@Service
public class EventLogBusiness {

	@Resource
	private EventLogRepository repository;
	
	@Transactional
	public void save(EventLog entity){
		repository.save(entity);
	}
	
	
}
