package com.huawei.doctor._4_problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei._1_model.body_pro.BodyProblem;
import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei.doctor._4_problem.provider.MainProvider;

@Component
public class ProblemService {
	// #region Fields

	@Autowired
	public static BodyProblemRepository bpRepo;

	// #endregion

	// #region updateProblems

	public void updateProblems(String strProblemKeyword) {
		MainProvider.updateProblems(strProblemKeyword, bpRepo);
	}

	// #endregion

	// #region queryProblem

	public BodyProblem queryProblem(String strProblemQuestion) {
		return MainProvider.queryProblem(strProblemQuestion, bpRepo);
	}

	// #endregion
}
