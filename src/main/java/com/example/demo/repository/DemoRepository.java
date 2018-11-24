package com.example.demo.repository;

import com.example.demo.bean.Demo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DemoRepository extends PagingAndSortingRepository<Demo, String> {

}
