package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class EventLog {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	private MessageType messageType;
	
	private String messageBody;
	
	private Date createtime;
	
	private Date updatetime;

}
