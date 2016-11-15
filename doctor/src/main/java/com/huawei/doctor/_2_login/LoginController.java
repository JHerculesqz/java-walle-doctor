package com.huawei.doctor._2_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_model.user.User;

@Controller
@EnableAutoConfiguration
public class LoginController {
	// #region Fields

	@Autowired
	public LoginService loginService;

	// #endregion

	// #region queryUserInfo

	/**
	 * 登录时,获取用户信息<br>
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("doctor/login/queryUserInfo")
	@ResponseBody
	public User queryUserInfo(@RequestBody String strName) {
		return loginService.queryUserInfo(strName);
	}

	// #endregion
}
