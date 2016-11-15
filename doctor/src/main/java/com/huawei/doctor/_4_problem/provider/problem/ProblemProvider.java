package com.huawei.doctor._4_problem.provider.problem;

import com.huawei._1_model.body_pro.BodyProblem;
import com.huawei._1_model.body_pro.BodyProblemRepository;

public class ProblemProvider {
	// #region updateProblems

	public static void updateProblems(String strProblemKeyword, BodyProblemRepository oBodyProblemRepository) {
		// 1.通过爬虫查找信息?
	}

	// #endregion

	// #region queryProblem

	public static BodyProblem queryProblem(String strProblemQuestion, BodyProblemRepository oBodyProblemRepository) {
		return oBodyProblemRepository.findByKeyWord(strProblemQuestion);
	}

	// #endregion
}
