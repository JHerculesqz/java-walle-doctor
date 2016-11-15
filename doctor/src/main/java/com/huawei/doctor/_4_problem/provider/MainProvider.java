package com.huawei.doctor._4_problem.provider;

import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei.doctor._4_problem.provider.problem.ProblemProvider;

public class MainProvider {
	// #region updateProblems

	public static void updateProblems(String strProblemKeyword, BodyProblemRepository oBodyProblemRepository) {
		ProblemProvider.updateProblems(strProblemKeyword, oBodyProblemRepository);
	}

	// #endregion

	// #region queryProblem

	public static void queryProblem(String strProblemQuestion, BodyProblemRepository oBodyProblemRepository) {
		ProblemProvider.queryProblem(strProblemQuestion, oBodyProblemRepository);
	}

	// #endregion
}
