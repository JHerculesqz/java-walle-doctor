package com.huawei.doctor._4_spider;

import java.util.List;

import org.springframework.stereotype.Component;

import com.huawei.doctor._4_spider.provider.MainProvider;
import com.huawei.doctor._4_spider.provider.vo.SpiderQuesAnsVo;

@Component
public class SpiderService {
	// #region spiderQuestionAndAnswer

	public List<SpiderQuesAnsVo> spiderQuestionAndAnswer(String strQuestionKeyWord) {
		return MainProvider.spiderQuestionAndAnswer(strQuestionKeyWord);
	}

	// #endregion
}
