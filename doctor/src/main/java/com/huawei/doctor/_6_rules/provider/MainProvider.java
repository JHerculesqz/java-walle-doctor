package com.huawei.doctor._6_rules.provider;

import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei._1_model.sickness.SicknessProcessRepository;
import com.huawei._1_model.user.User;
import com.huawei.doctor._4_problem.provider.problem.ProblemProvider;
import com.huawei.doctor._6_rules.provider.rules.RulesProvider;

public class MainProvider {
	// #region updateProblems

	public static void updateProblems(String strProblemKeyword, BodyProblemRepository oBodyProblemRepository) {
		ProblemProvider.updateProblems(strProblemKeyword, oBodyProblemRepository);
	}

	// #endregion

	// #region updateSickness

	public static void updateSickness(User oUser, SicknessProcessRepository oSicknessProcessRepository) {
		RulesProvider.updateSickness(oUser, oSicknessProcessRepository);
	}

	// #endregion

	// #region startXXX

	public static String startWarn(String strUsername, SicknessProcessRepository oSicknessProcessRepository) {
		return RulesProvider.startWarn(strUsername, oSicknessProcessRepository);
	}

	public static String startEmergency(String strUsername, SicknessProcessRepository oSicknessProcessRepository) {
		return RulesProvider.startEmergency(strUsername, oSicknessProcessRepository);
	}

	// #endregion
}
