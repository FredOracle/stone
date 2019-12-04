package com.example.demo.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Demo;
import com.example.demo.bean.DemoResponse;
import com.example.demo.business.DemoBusiness;
import com.example.demo.business.EventLogBusiness;
import com.example.demo.event.spring.CreatedEvent;
import com.example.demo.event.spring.EventPublisher;
import com.example.demo.event.spring.UpdatedEvent;
import com.example.demo.mongodb.MongoClient;
import com.example.demo.rabbitmq.RabbitReceiver;
import com.example.demo.redis.RedisClient;
import com.example.demo.util.MessageLogBuilder;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@RestController
@Slf4j
public class SystemRestController {

	@Resource
	private EventPublisher publisher;

	@Resource
	private RabbitReceiver receiver;

	@Resource
	private DemoBusiness demoBusiness;

	@Resource
	private EventLogBusiness eventLogBusiness;

	@Resource
	private RedisClient client;

	// @Resource
	// private RedisTemplate<String, String> template;

	// @Resource
	// private RedisUtil util;

	@Resource
	private MongoClient mongoClient;

	@RequestMapping(value = "logs", method = RequestMethod.GET)
	public String insertLog() {
		MessageLogBuilder builder = new MessageLogBuilder();
		for (int i = 0; i < 10000; i++) {
			eventLogBusiness.save(builder.build());
		}
		return "Success";
	}

	@ApiOperation(value = "query entity", notes = "no input parameters")
	@RequestMapping(value = "msg", method = RequestMethod.GET)
	public ResponseEntity<DemoResponse> msg() {

		Demo bean = Demo.builder().username(UUID.randomUUID().toString()).password(UUID.randomUUID().toString())
				.build();
		demoBusiness.insert(bean);

		CreatedEvent event = new CreatedEvent(this, bean.getUsername());
		publisher.createdPush(event);
		log.info("=============push event");

		UpdatedEvent updated = new UpdatedEvent(this, bean.getUsername() + "Updated");
		publisher.updatedPush(updated);

		Boolean hasKey = client.hasKey("hello");
		log.info("============Has Key  " + hasKey);
		client.saveKey("good", bean.getUsername());
		log.info(".............." + client.getKey("good"));

		// util.setValue("good", "Fred");
		// log.info(">>>>>>>>>>>>>>>>>" + util.hasKey("good"));
		// log.info(">>>>>>>>>>>>>>>>>" + util.getValue("good"));

		mongoClient.save(bean.getId(), bean.getUsername());

		return ResponseEntity.ok().body(DemoResponse.builder().msg("Hello Fred  【" + bean.getUsername() + "】").build());
	}

	@RequestMapping(value = "msg", method = RequestMethod.POST)
	@ApiOperation(value = "创建Demo实体", notes = "此接口有二个输入参数，一个是UserName， 一个是Password")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "age", value = "年纪", required = false, dataType = "Integer") })
	public String create(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "age", required = false) Integer age,

			@RequestHeader("Authorization") String authorization, @RequestHeader("User-Agent") String userAgent,
			@RequestHeader("Accept") String acceptType, @RequestHeader("Accept-Language") String acceptLang,
			@RequestHeader("Accept-Encoding") String acceptEnc, @RequestHeader("Cache-Control") String cacheCon,
			@RequestHeader("Cookie") String cookie) {
		Demo bean = Demo.builder().username(UUID.randomUUID().toString()).password(UUID.randomUUID().toString())
				.build();
		System.out.println("========MSG===================" + demoBusiness.insert(bean));
		return "{\"msg\":\"Hello Fred\"}";
	}

	@RequestMapping(value = "msg", method = RequestMethod.PUT)
	public String update() {
		Demo bean = Demo.builder().username(UUID.randomUUID().toString()).password(UUID.randomUUID().toString())
				.build();
		System.out.println("========MSG===================" + demoBusiness.insert(bean));
		return "{\"msg\":\"Hello Fred\"}";
	}
}
