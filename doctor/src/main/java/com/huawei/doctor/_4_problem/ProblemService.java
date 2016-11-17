package com.huawei.doctor._4_problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.huawei._1_model.body_pro.BodyProblem;
import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei.doctor._4_problem.provider.MainProvider;

@Component
public class ProblemService {
	// #region Fields

	@Autowired
	public BodyProblemRepository bpRepo;

	@Autowired
	public MongoTemplate mongoTemplate;

	// #endregion

	// #region updateProblems

	public BodyProblem updateProblems(String strProblemKeyword) {
		return MainProvider.updateProblems(strProblemKeyword, bpRepo, mongoTemplate);
	}

	// #endregion

	// #region queryProblem

	public BodyProblem queryProblem(String strProblemQuestion) {
		return MainProvider.queryProblem(strProblemQuestion, bpRepo, mongoTemplate);
	}

	// #endregion
}
