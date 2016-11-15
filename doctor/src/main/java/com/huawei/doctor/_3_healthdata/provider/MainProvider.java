package com.huawei.doctor._3_healthdata.provider;

import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;
import com.huawei.doctor._3_healthdata.provider.healthdata.HealthDataProvider;

public class MainProvider {
	// #region setOneHealthData

	public static void setOneHealthData(User oUser, UserRepository oUserRepository,
			HealthDataRepository oHealthDataRepository) {
		HealthDataProvider.setOneHealthData(oUser, oUserRepository, oHealthDataRepository);
	}

	// #endregion
}
