package com.huawei._1_model.sickness;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SicknessProcessRepository extends MongoRepository<SicknessProcess, String>{
	public SicknessProcess findByUserName(String userName);
}
