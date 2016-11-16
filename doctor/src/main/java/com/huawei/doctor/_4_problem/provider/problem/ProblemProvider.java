package com.huawei.doctor._4_problem.provider.problem;

import java.util.List;

import com.huawei._1_model.body_pro.BodyProblem;
import com.huawei._1_model.body_pro.BodyProblemRepository;
import com.huawei.doctor._5_spider.provider.hdf.HdfProvider;
import com.huawei.doctor._5_spider.provider.vo.SpiderQuesAnsVo;

public class ProblemProvider {
	// #region updateProblems

	public static void updateProblems(String strProblemKeyword, BodyProblemRepository oBodyProblemRepository) {
		// 1.通过爬虫查找信息
		List<SpiderQuesAnsVo> lstSpiderQuesAnsVo = HdfProvider.spiderQuestionAndAnswer(strProblemKeyword);

		// 2.将问题的答案入库
		for (SpiderQuesAnsVo oSpiderQuesAnsVo : lstSpiderQuesAnsVo) {
			BodyProblem oBodyProblem = new BodyProblem(oSpiderQuesAnsVo.getQuestion(), oSpiderQuesAnsVo.getAnswer());
			oBodyProblemRepository.insert(oBodyProblem);
		}
	}

	// #endregion

	// #region queryProblem

	public static BodyProblem queryProblem(String strProblemQuestion, BodyProblemRepository oBodyProblemRepository) {
		return oBodyProblemRepository.findByKeyWord(strProblemQuestion);
	}

	// #endregion
}
