package com.example.demo.business;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoBusiness {
	
	@Resource
	private DemoRepository repository;
	
	public String insert(Demo bean){
		repository.save(bean);
		return bean.getId();
	}

	
//	public List<Demo> getAll(){
//		return Collections.list(repository.findAll());
//	}
}
