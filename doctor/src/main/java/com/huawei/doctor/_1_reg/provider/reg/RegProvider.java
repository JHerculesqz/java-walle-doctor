package com.huawei.doctor._1_reg.provider.reg;

import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;

public class RegProvider {
	// #region saveUserInfo

	public static String saveUserInfo(User oUser, UserRepository oUserRepository) {
		// 1.将用户信息入库
		oUserRepository.save(oUser);
		
		return "success";
	}

	// #endregion
}
