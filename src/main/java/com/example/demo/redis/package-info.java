/**
 * 这个包是Spring整合Redis，Redis的连接信息在application.properties文件中.
 * RedisClient文件是通过Jedis连接Redis，并通过这个Client对Redis进行操作
 * RedisUtil文件是通过Spring的方式（StringRedisTemplate），当然也可以用RedisTemplate进行封装对Redis的操作
 * 
 * 
 * #Redis
	spring.redis.host=192.168.86.133
	spring.redis.port=6379
	spring.redis.database=0
	spring.redis.timeout=3000


	@Resource
	private StringRedisTemplate template;
 */
/**
 * @author Fred
 *
 */
package com.example.demo.redis;

