package com.huawei.doctor._1_reg.provider;

import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;
import com.huawei.doctor._1_reg.provider.reg.RegProvider;

public class MainProvider {
	// #region saveUserInfo

	public static User saveUserInfo(User oUser, UserRepository oUserRepository) {
		return RegProvider.saveUserInfo(oUser, oUserRepository);
	}

	// #endregion
}
