package com.huawei.doctor._4_problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei._1_model.body_pro.BodyProblem;

@Controller
@EnableAutoConfiguration
public class ProblemController {
	// #region Fields

	@Autowired
	public ProblemService problemService;

	// #endregion

	// #region updateProblems

	/**
	 * 模拟智能设备获取一份健康数据<br>
	 * 
	 * @param user
	 */
	@RequestMapping("doctor/problem/updateProblems")
	@ResponseBody
	public BodyProblem updateProblems(@RequestBody BodyProblem oBodyProblem) {
		return problemService.updateProblems(oBodyProblem.getKeyWord());
	}

	// #endregion

	// #region queryProblem

	/**
	 * queryProblem<br>
	 * 
	 * @param user
	 */
	@RequestMapping("doctor/problem/queryProblem")
	@ResponseBody
	public BodyProblem queryProblem(@RequestBody BodyProblem oBodyProblem) {
		return problemService.queryProblem(oBodyProblem.getKeyWord());
	}

	// #endregion
}
