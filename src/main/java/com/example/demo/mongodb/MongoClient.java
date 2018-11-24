package com.example.demo.mongodb;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MongoClient {

    @Resource
    private MongoTemplate mongoTemplate;

    public String save(String key, String value){
        mongoTemplate.save(value);
        return value;
    }

}
