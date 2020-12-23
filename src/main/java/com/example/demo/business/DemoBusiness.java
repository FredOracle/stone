package com.example.demo.business;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.demo.bean.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoBusiness {

  @Resource
  private DemoRepository repository;

  public String insert(Demo bean) {
    Demo entity = bean;
    repository.save(entity);
    return entity.getId();
  }

//	public List<Demo> getAll(){
//		return Collections.list(repository.findAll());
//	}
}
