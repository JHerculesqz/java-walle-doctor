package com.huawei.doctor._3_healthdata.provider.healthdata;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.healthdata.HeathData;
import com.huawei._1_model.user.User;

public class HealthDataProvider {
	// #region setOneHealthData

	public static void setOneHealthData(User oUser, HealthDataRepository oHealthDataRepository) {
		HeathData heathData = fakeCollectHeathData(oUser.getName());
		oHealthDataRepository.save(heathData);
	}

	private static String[] lstBloodPressure = { "120", "115", "134", "138", "108", "111" };
	private static String[] lstBodyFatRate = { "18%", "15%", "20%", "35%", "22%" };
	private static String[] lstHeartRate = { "68", "73", "90", "88", "101" };
	private static String[] lstHeight = { "170", "193", "167", "155", "181", "162" };
	private static String[] lstSleepHours = { "8h", "9h", "6h", "7h" };
	private static String[] lstSleepState = { "very good", "good", "normal", "bad" };
	private static String[] lstTemperature = { "37.1", "36.5", "37.5", "36.9" };
	private static String[] lstWeight = { "64kg", "55kg", "52kg", "80kg", "73kg" };

	private static HeathData fakeCollectHeathData(String userName) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HeathData oHealthData = new HeathData(userName, df.format(new Date()));

		oHealthData.setBloodPressure(lstBloodPressure[new Random(lstBloodPressure.length).nextInt()]);
		oHealthData.setBodyFatRate(lstBodyFatRate[new Random(lstBodyFatRate.length).nextInt()]);
		oHealthData.setHeartRate(lstHeartRate[new Random(lstHeartRate.length).nextInt()]);
		oHealthData.setHeight(lstHeight[new Random(lstHeight.length).nextInt()]);
		oHealthData.setSleepHours(lstSleepHours[new Random(lstSleepHours.length).nextInt()]);
		oHealthData.setSleepState(lstSleepState[new Random(lstSleepState.length).nextInt()]);
		oHealthData.setTemperature(lstTemperature[new Random(lstTemperature.length).nextInt()]);
		oHealthData.setWeight(lstWeight[new Random(lstWeight.length).nextInt()]);

		return oHealthData;
	}

	// #endregion
}
