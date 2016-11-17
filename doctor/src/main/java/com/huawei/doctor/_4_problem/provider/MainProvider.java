package com.huawei.doctor._4_problem.provider;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.huawei._1_model.body_pro.BodyProblem;
import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei.doctor._4_problem.provider.problem.ProblemProvider;

public class MainProvider {
	// #region updateProblems

	public static BodyProblem updateProblems(String strProblemKeyword, BodyProblemRepository oBodyProblemRepository,
			MongoTemplate mongoTemplate) {

		ProblemProvider.updateProblems(strProblemKeyword, oBodyProblemRepository);
		BodyProblem oBodyProblem = new BodyProblem();
		oBodyProblem.setKeyWord(strProblemKeyword);
		oBodyProblem.setAnswer("Ñ§Ï°Íê³É");
		return oBodyProblem;

	}

	// #endregion

	// #region queryProblem

	public static BodyProblem queryProblem(String strProblemQuestion, BodyProblemRepository oBodyProblemRepository,
			MongoTemplate mongoTemplate) {
		return ProblemProvider.queryProblem(strProblemQuestion, oBodyProblemRepository, mongoTemplate);
	}

	// #endregion
}
