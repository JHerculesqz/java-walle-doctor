package com.huawei.doctor._3_healthdata.provider;

import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.user.User;
import com.huawei.doctor._3_healthdata.provider.healthdata.HealthDataProvider;

public class MainProvider {
	// #region setOneHealthData

	public static void setOneHealthData(User oUser, HealthDataRepository oHealthDataRepository) {
		HealthDataProvider.setOneHealthData(oUser, oHealthDataRepository);
	}

	// #endregion
}
