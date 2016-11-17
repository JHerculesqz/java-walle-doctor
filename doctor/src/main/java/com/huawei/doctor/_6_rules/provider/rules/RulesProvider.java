package com.huawei.doctor._6_rules.provider.rules;

import java.util.List;
import java.util.Random;

import com.huawei._1_model.sickness.SicknessProcess;
import com.huawei._1_model.sickness.SicknessProcessRepository;
import com.huawei._1_model.user.User;

public class RulesProvider {
	// #region updateSickness

	public static void updateSickness(User oUser, SicknessProcessRepository oSicknessProcessRepository) {
		// 1.�û���ÿһ�ּ��������ڼ����������̿������һ����¼
		List<String> lstSickness = oUser.getLstSickness();
		for (String sickness : lstSickness) {
			// 1.1.α��һ�����û��ļ����������̷���
			SicknessProcess oSicknessProcess = fakeSicknessProcess(sickness);
			oSicknessProcess.setUserName(oUser.getName());

			// 1.2.���û��ļ��������������
			oSicknessProcessRepository.save(oSicknessProcess);
		}
	}

	private static String[] vecProcessCycle = { "everyday", "week", "hour", "month" };
	private static String[] vecProcessDetail = { "��ʼ��ҩ��", "��ʼ��������", "��ʼ��Ѫѹ��", "��ɢ����" };
	private static String[] vecEmergencyDetail = { "����120", "��绰����ҽ��", "������������" };

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
