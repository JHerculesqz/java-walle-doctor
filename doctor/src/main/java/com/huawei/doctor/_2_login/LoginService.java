package com.huawei.doctor._2_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;
import com.huawei.doctor._2_login.provider.MainProvider;

@Component
public class LoginService {
	// #region Fields

	@Autowired
	public static UserRepository userRepo;

	// #endregion

	// #region queryUserInfo

	public User queryUserInfo(String strName) {
		return MainProvider.queryUserInfo(strName, userRepo);
	}

	// #endregion
}
