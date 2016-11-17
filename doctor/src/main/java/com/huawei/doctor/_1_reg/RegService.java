package com.huawei.doctor._1_reg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;
import com.huawei.doctor._1_reg.provider.MainProvider;

@Component
public class RegService {
	// #region Fields

	@Autowired
	public UserRepository userRepo;

	// #endregion

	// #region saveUserInfo

	public User saveUserInfo(User oUser) {
		return MainProvider.saveUserInfo(oUser, userRepo);
	}

	// #endregion
}
