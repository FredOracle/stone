package com.example.demo.util;

import java.util.Date;
import java.util.UUID;

import com.example.demo.bean.EventLog;
import com.example.demo.bean.MessageType;

public class MessageLogBuilder {

	public static EventLog build(){
		EventLog log = EventLog.builder().build();
		log.setCreatetime(new Date());
		log.setMessageType(MessageType.AAC);
		log.setMessageBody(UUID.randomUUID().toString());
		log.setUpdatetime(new Date());
		return log;
	}
}
