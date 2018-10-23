package com.example.demo.business;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoBusiness {
	
	@Resource
	private DemoRepository repository;
	
	public Integer insert(Demo bean){
		repository.save(bean);
		return bean.getId();
	}

}
