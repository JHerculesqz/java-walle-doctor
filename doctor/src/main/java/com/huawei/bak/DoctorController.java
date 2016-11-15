package com.huawei.bak;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei._1_model.healthdata.HealthDataRepository;
import com.huawei._1_model.healthdata.HeathData;
import com.huawei._1_model.sickness.SicknessProcessRepository;
import com.huawei._1_model.user.User;
import com.huawei._1_model.user.UserRepository;

@Controller
@EnableAutoConfiguration
public class DoctorController {
	// #region login

	/**
	 * 注册时，保存用户信息<br>
	 * 
	 * @param user
	 */
	@RequestMapping("login/saveUserInfo")
	@ResponseBody
	public String saveUserInfo(@RequestBody User user) {
		return "还没实现呢";
	}

	/**
	 * 登录时,获取用户信息<br>
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("login/queryUserInfo")
	@ResponseBody
	public User queryUserInfo(@RequestBody String name) {
		return null;
	}

	/**
	 * 模拟智能设备获取一份健康数据<br>
	 * 
	 * @param user
	 */
	@RequestMapping("login/setOneHeathData")
	@ResponseBody
	public void setOneHeathData(@RequestBody User user) {
		HeathData heathData = fakeCollectHeathData();
		user.addHeathData(heathData);
	}

	private HeathData fakeCollectHeathData() {
		HeathData heathData = new HeathData("", "");

		// TODO：随机构造健康数据

		return heathData;
	}

	/**
	 * 更新疾病列表,开始看病时调用<br>
	 * 
	 * @param user
	 */
	@RequestMapping("login/updateSickness")
	@ResponseBody
	public void updateSickness(@RequestBody User user) {

	}

	/**
	 * 更新常规问题,供数据挖掘系统调用<br>
	 * 
	 * @param problem
	 */
	@RequestMapping("login/updateProblems")
	@ResponseBody
	public void updateProblems(@RequestBody String problem) {

	}

	// #endregion

	// #region query problem

	/**
	 * 中文分词<br>
	 * 
	 * @param words
	 * @return
	 */
	@RequestMapping("query/splitChineseWords")
	@ResponseBody
	public List<String> splitChineseWords(@RequestBody String words) {
		return null;
	}

	/**
	 * 查询问题<br>
	 * 
	 * @param words
	 * @return 答案
	 */
	@RequestMapping("query/queryProblem")
	@ResponseBody
	public String queryProblem(@RequestBody String problem) {
		return "";
	}

	// #endregion

	// #region sickness-help

	/**
	 * 触发提醒规则<br>
	 * 
	 * @param problem
	 * @return
	 */
	@RequestMapping("sicknessHelp/startWarn")
	@ResponseBody
	public String startWarn(@RequestBody String sickness) {
		return "";
	}

	/**
	 * 触发应急规则<br>
	 * 
	 * @param problem
	 * @return
	 */
	@RequestMapping("sicknessHelp/startEmergency")
	@ResponseBody
	public String startEmergency(@RequestBody String sickness) {
		return "";
	}

	// #endregion

	// #region test

	@Autowired
	public static UserRepository userRepo;

	@Autowired
	public static SicknessProcessRepository sicknessRepo;

	@Autowired
	public static HealthDataRepository hdRepo;

	@Autowired
	public static BodyProblemRepository bpRepo;

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		userRepo.deleteAll();

		// save a couple of customers
		userRepo.save(new User("zxc", "man", 30));
		userRepo.save(new User("vivi", "female", 28));

		// fetch all customers
		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");

		String res = "";
		for (User user : userRepo.findAll()) {
			res += user.toString();
		}

		return res;
	}

	// #endregion
}
