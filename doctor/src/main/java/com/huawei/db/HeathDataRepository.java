package com.huawei.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.huawei.model.HeathData;

public interface HeathDataRepository extends MongoRepository<HeathData, String>{
	// TODO:为什么不能是联合查询？
	//	public HeathData findByNameAndTime(String userName, String collectTime);
}
