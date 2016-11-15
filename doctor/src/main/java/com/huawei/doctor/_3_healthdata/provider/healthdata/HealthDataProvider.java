package com.huawei.doctor._3_healthdata.provider.healthdata;

import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.healthdata.HeathData;
import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;

public class HealthDataProvider {
	// #region setOneHealthData

	public static void setOneHealthData(User oUser, UserRepository oUserRepository,
			HealthDataRepository oHealthDataRepository) {
		HeathData heathData = fakeCollectHeathData();
		// oHealthDataRepository.addHeathData(heathData);
	}

	private static HeathData fakeCollectHeathData() {
		HeathData heathData = new HeathData("", "");

		// TODO：随机构造健康数据

		return heathData;
	}

	// #endregion
}
