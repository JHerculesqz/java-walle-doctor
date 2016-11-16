package com.huawei.doctor._6_rules.provider.rules;

import java.util.List;
import java.util.Random;

import com.huawei._1_model.sickness.SicknessProcess;
import com.huawei._1_model.sickness.SicknessProcessRepository;
import com.huawei._1_model.user.User;

public class RulesProvider {
	// #region updateSickness

	public static void updateSickness(User oUser, SicknessProcessRepository oSicknessProcessRepository) {
		// 1.用户的每一种疾病，都在疾病辅导流程库中添加一条记录
		List<String> lstSickness = oUser.getLstSickness();
		for (String sickness : lstSickness) {
			SicknessProcess oSicknessProcess = oSicknessProcessRepository.findBySickness(sickness);
			// 1.1.疾病辅导流程库中没有该疾病，则伪造一条辅导流程记录
			if (null == oSicknessProcess) {
				oSicknessProcess = fakeSicknessProcess(sickness);
			}

			// 1.2.为该用户创建一条辅导流程（应该可以直接使用oSicknessProcess？）
			oSicknessProcess.setUserName(oUser.getName());

			// 1.3.该用户的疾病辅导流程入库
			oSicknessProcessRepository.save(oSicknessProcess);
		}
	}

	private static String[] vecProcessCycle = { "everyday", "week", "hour", "month" };
	private static String[] vecProcessDetail = { "开始吃药了", "开始量体温了", "开始量血压了", "该散步了" };
	private static String[] vecEmergencyDetail = { "拨打120", "打电话给王医生", "启动警报音乐" };

	private static SicknessProcess fakeSicknessProcess(String sickness) {
		SicknessProcess oSicknessProcess = new SicknessProcess();
		oSicknessProcess.setSickness(sickness);
		oSicknessProcess.setProcessCycle(vecProcessCycle[new Random(vecProcessCycle.length).nextInt()]);
		oSicknessProcess.setProcessDetail(vecProcessDetail[new Random(vecProcessDetail.length).nextInt()]);
		oSicknessProcess.setEmergencyDetail(vecEmergencyDetail[new Random(vecEmergencyDetail.length).nextInt()]);

		return oSicknessProcess;
	}

	// #endregion

	// #region startXXX

	public static String startWarn(String strUsername, SicknessProcessRepository oSicknessProcessRepository) {
		SicknessProcess oSicknessProcess = oSicknessProcessRepository.findByUserName(strUsername);
		if (null != oSicknessProcess) {
			return oSicknessProcess.getProcessDetail();
		}
		return strUsername + "not exist";
	}

	public static String startEmergency(String strUsername, SicknessProcessRepository oSicknessProcessRepository) {
		SicknessProcess oSicknessProcess = oSicknessProcessRepository.findByUserName(strUsername);
		if (null != oSicknessProcess) {
			return oSicknessProcess.getEmergencyDetail();
		}
		return strUsername + "not exist";
	}

	// #endregion
}
