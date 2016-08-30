package com.rensframework.user.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rensframework.entity.User;

@Repository
public interface UserDao extends MongoRepository<User, String> {

	@Query("{ name: ?0 }")
	public List<User> findByName(String userName);

	@Query("{ account: ?0 }")
	public User findByAccount(String account);

}
