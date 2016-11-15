package com.huawei.doctor._1_reg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_model.user.User;

@Controller
@EnableAutoConfiguration
public class RegController {
	// #region Fields

	@Autowired
	public RegService regService;

	// #endregion

	// #region saveUserInfo

	/**
	 * 注册时，保存用户信息<br>
	 * 
	 * @param oUser
	 */
	@RequestMapping("doctor/login/saveUserInfo")
	@ResponseBody
	public String saveUserInfo(@RequestBody User oUser) {
		return regService.saveUserInfo(oUser);
	}

	// #endregion
}
