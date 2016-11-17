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
	 * ע��ʱ�������û���Ϣ<br>
	 * 
	 * @param oUser
	 */
	@RequestMapping("doctor/login/saveUserInfo")
	@ResponseBody
	public User saveUserInfo(@RequestBody User oUser) {
		return regService.saveUserInfo(oUser);
	}

	// #endregion
}
