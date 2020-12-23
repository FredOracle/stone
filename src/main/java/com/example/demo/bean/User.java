package com.example.demo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 5676537290353060886L;
	
	@Id
	@GenericGenerator(name = "system-uuid", strategy="uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column
	private String username;
	
	private String password;
	
	private Date createtime;
	
	private Date updatetime;
	
	@Builder.Default
	@OneToMany(targetEntity=Role.class, cascade=CascadeType.ALL)
	private List<Role> roles = new ArrayList<>();

	
}
