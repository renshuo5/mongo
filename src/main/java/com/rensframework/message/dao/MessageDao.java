package com.rensframework.message.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rensframework.entity.Message;

public interface MessageDao extends MongoRepository<Message, String> {
	
	
	@Query(value="{ fromId: ?0 }")
	public Page<Message> findByFromId(String id,Pageable pageable);
	
	public List<Message> findByFromId(String id);

	public List<Message> findByToId(String id);
	

}
