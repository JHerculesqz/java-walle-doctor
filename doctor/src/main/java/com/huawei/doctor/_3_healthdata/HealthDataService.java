package com.huawei.doctor._3_healthdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;
import com.huawei.doctor._3_healthdata.provider.MainProvider;

@Component
public class HealthDataService {
	// #region Fields

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private HealthDataRepository healthDataRepo;

	// #endregion

	// #region setOneHealthData

	public void setOneHealthData(User oUser) {
		MainProvider.setOneHealthData(oUser, userRepo, healthDataRepo);
	}

	// #endregion
}
