package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.EventLog;

public interface EventLogRepository extends CrudRepository<EventLog, String> {

}
