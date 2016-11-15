package com.huawei.doctor._3_healthdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_model.user.User;

@Controller
@EnableAutoConfiguration
public class HealthDataController {
	// #region Fields

	@Autowired
	public HealthDataService healthDataService;

	// #endregion

	// #region setOneHealthData

	/**
	 * 模拟智能设备获取一份健康数据<br>
	 * 
	 * @param user
	 */
	@RequestMapping("doctor/healthdata/setOneHealthData")
	@ResponseBody
	public void setOneHealthData(@RequestBody User oUser) {
		healthDataService.setOneHealthData(oUser);
	}

	// #endregion
}
