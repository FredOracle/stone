package com.example.demo.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	
	@Resource
	private StringRedisTemplate template;
	
	
	public Boolean hasKey(String key){
		return template.hasKey(key);
	}
	
	public void setValue(String key, String value){
		if(template.hasKey(key)){
			template.boundValueOps(key).set(value);
//			template.boundHashOps(key).put(key, value);
		}
	}
	
	public String getValue(String key){
		if(template.hasKey(key)){
			return template.boundValueOps(key).get();
		}else{
			throw new NullPointerException();
		}
	}

	
	public void subscribe(String key){
		template.watch(key);
	}
	
	public void push(String key, String value){

	
	}
}
