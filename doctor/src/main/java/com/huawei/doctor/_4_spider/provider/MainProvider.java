package com.huawei.doctor._4_spider.provider;

import java.util.List;

import com.huawei.doctor._4_spider.provider.hdf.HdfProvider;
import com.huawei.doctor._4_spider.provider.vo.SpiderQuesAnsVo;

public class MainProvider {
	// #region spiderQuestionAndAnswer

	public static List<SpiderQuesAnsVo> spiderQuestionAndAnswer(String strQuestionKeyWord) {
		return HdfProvider.spiderQuestionAndAnswer(strQuestionKeyWord);
	}

	// #endregon
}
