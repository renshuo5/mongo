package com.rensframework.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rensframework.entity.Message;
import com.rensframework.message.dao.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	public List<Message> findByFromId(String id){
		return messageDao.findByFromId(id);
	}
	
	public List<Message> findByToId(String id){
		return messageDao.findByToId(id);
	}

	public Message create(Message mess) {
		return messageDao.insert(mess);
	}

}
