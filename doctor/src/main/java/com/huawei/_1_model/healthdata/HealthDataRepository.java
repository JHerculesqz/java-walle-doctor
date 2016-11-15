package com.huawei._1_model.healthdata;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HealthDataRepository extends MongoRepository<HeathData, String>{
	// TODO:为什么不能是联合查询？
	//	public HeathData findByNameAndTime(String userName, String collectTime);
}
