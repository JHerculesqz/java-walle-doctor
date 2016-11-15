package com.huawei.doctor._2_login.provider;

import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;
import com.huawei.doctor._2_login.provider.login.LoginProvider;

public class MainProvider {
	// #region queryUserInfo

	public static User queryUserInfo(String strName, UserRepository oUserRepository) {
		return LoginProvider.queryUserInfo(strName, oUserRepository);
	}

	// #endregion
}
