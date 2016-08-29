package com.rensframework.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usr_user")
@Getter@Setter
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9089735584195932757L;

	private String id;
	
	private String name;
	
	private String account;
	
	private String password;
	
	@DBRef(lazy=true)
	private Set<User> friends;

}

