package com.huawei.doctor._3_healthdata.provider.healthdata;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.healthdata.HeathData;
import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;

public class HealthDataProvider {
	// #region setOneHealthData

	public static void setOneHealthData(User oUser, UserRepository oUserRepository,
			HealthDataRepository oHealthDataRepository) {
		HeathData heathData = fakeCollectHeathData(oUser.getName());
		oHealthDataRepository.save(heathData);
	}

	private static HeathData fakeCollectHeathData(String userName) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		HeathData oHealthData = new HeathData(userName, df.format(new Date()));

		oHealthData.setBloodPressure("128");
		oHealthData.setBodyFatRate("24%");
		oHealthData.setHeartRate("80");
		oHealthData.setHeight("173");
		oHealthData.setSleepHours("7h");
		oHealthData.setSleepState("very good");
		oHealthData.setTemperature("36.8");
		oHealthData.setWeight("60kg");

		return oHealthData;
	}

	// #endregion
}
