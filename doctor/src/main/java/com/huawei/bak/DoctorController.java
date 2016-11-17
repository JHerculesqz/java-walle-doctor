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
	 * ע��ʱ�������û���Ϣ<br>
	 * 
	 * @param user
	 */
	@RequestMapping("login/saveUserInfo")
	@ResponseBody
	public String saveUserInfo(@RequestBody User user) {
		return "��ûʵ����";
	}

	/**
	 * ��¼ʱ,��ȡ�û���Ϣ<br>
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
	 * ģ�������豸��ȡһ�ݽ�������<br>
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

		// TODO��������콡������

		return heathData;
	}

	/**
	 * ���¼����б�,��ʼ����ʱ����<br>
	 * 
	 * @param user
	 */
	@RequestMapping("login/updateSickness")
	@ResponseBody
	public void updateSickness(@RequestBody User user) {

	}

	/**
	 * ���³�������,�������ھ�ϵͳ����<br>
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
	 * ���ķִ�<br>
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
	 * ��ѯ����<br>
	 * 
	 * @param words
	 * @return ��
	 */
	@RequestMapping("query/queryProblem")
	@ResponseBody
	public String queryProblem(@RequestBody String problem) {
		return "";
	}

	// #endregion

	// #region sickness-help

	/**
	 * �������ѹ���<br>
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
	 * ����Ӧ������<br>
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
	public UserRepository userRepo;

	@Autowired
	public SicknessProcessRepository sicknessRepo;

	@Autowired
	public HealthDataRepository hdRepo;

	@Autowired
	public BodyProblemRepository bpRepo;

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		this.userRepo.deleteAll();

		// save a couple of customers
		this.userRepo.save(new User("zxc", "man", "30"));
		this.userRepo.save(new User("vivi", "female", "28"));

		// fetch all customers
		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");

		String res = "";
		for (User user : this.userRepo.findAll()) {
			res += user.toString();
		}
		System.out.println(res);

		return res;
	}

	// #endregion
}
