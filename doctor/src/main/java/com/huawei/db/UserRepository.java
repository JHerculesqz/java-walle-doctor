package com.huawei.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.huawei.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	public User findByName(String name);
}
