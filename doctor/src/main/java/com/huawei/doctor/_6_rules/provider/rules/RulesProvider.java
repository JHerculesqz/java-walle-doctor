package com.huawei.doctor._6_rules.provider.rules;

import com.huawei._1_model.sickness.SicknessProcess;
import com.huawei._1_model.sickness.SicknessProcessRepository;
import com.huawei._1_model.user.User;

public class RulesProvider {
	// #region updateSickness

	public static void updateSickness(User oUser, SicknessProcessRepository oSicknessProcessRepository) {
	}

	// #endregion

	// #region startXXX

	public static String startWarn(String strUsername, SicknessProcessRepository oSicknessProcessRepository) {
		SicknessProcess oSicknessProcess = oSicknessProcessRepository.findByUserName(strUsername);
		if (null != oSicknessProcess)
		{
			return oSicknessProcess.getProcessDetail();
		}
		return strUsername + "not exist";
	}

	public static String startEmergency(String strUsername, SicknessProcessRepository oSicknessProcessRepository) {
		SicknessProcess oSicknessProcess = oSicknessProcessRepository.findByUserName(strUsername);
		if (null != oSicknessProcess)
		{
			return oSicknessProcess.getEmergencyDetail();
		}
		return strUsername + "not exist";
	}

	// #endregion
}
