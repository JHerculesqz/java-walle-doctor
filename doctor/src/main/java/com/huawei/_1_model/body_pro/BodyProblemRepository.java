package com.huawei._1_model.body_pro;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BodyProblemRepository extends MongoRepository<BodyProblem, String> {
	public BodyProblem findByKeyWord(String keyWord);
}
