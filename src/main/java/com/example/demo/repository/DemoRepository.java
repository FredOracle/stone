package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Demo;

public interface DemoRepository extends CrudRepository<Demo, Long>{

}
