package com.huawei.doctor._4_problem.provider.problem;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

	public static BodyProblem queryProblem(String strProblemQuestion, BodyProblemRepository oBodyProblemRepository,
			MongoTemplate mongoTemplate) {

		Pattern pattern = Pattern.compile("^.*" + strProblemQuestion + ".*$", Pattern.CASE_INSENSITIVE);
		Query query = Query.query(Criteria.where("keyWord").regex(pattern));
		List<BodyProblem> users = mongoTemplate.find(query, BodyProblem.class);
		if (null == users || users.size() == 0) {

			BodyProblem oBodyProblem = new BodyProblem();
			oBodyProblem.setKeyWord(strProblemQuestion);
			oBodyProblem.setAnswer("learn");
			return oBodyProblem;
		}
		int index = new Random().nextInt(users.size());
		return users.get(index);

		// return oBodyProblemRepository.findByKeyWord(strProblemQuestion);
	}

	// #endregion
}
