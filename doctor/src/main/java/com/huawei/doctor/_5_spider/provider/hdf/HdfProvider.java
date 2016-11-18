package com.huawei.doctor._5_spider.provider.hdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.huawei._1_fw.spider.SpiderUtils;
import com.huawei._1_fw.spider.vo.SpiderResVo;
import com.huawei.doctor._5_spider.provider.vo.SpiderQuesAnsVo;

public class HdfProvider {
	// #region Const
	
	public static final String KEY_WORD_1 = "心脏病";
	
	public static final String KEY_WORD_2= "高血压";
	
	// #endregion

	// #region spiderQuestionAndAnswer

	public static List<SpiderQuesAnsVo> spiderQuestionAndAnswer(String strQuestionKeyWord) {
		List<SpiderQuesAnsVo> lstRes = new ArrayList<SpiderQuesAnsVo>();

		// 1.spider.run
		if (strQuestionKeyWord.equals(HdfProvider.KEY_WORD_1)) {
			SpiderUtils.run("C:\\z.doctor_test", "http://dengyz.haodf.com/lanmu", "http://www.haodf.com/");
		}
		else if(strQuestionKeyWord.equals(HdfProvider.KEY_WORD_2)){
			SpiderUtils.run("C:\\z.doctor_test", "http://drtaobo.haodf.com/lanmu", "http://www.haodf.com/");
		}
		// 2.parse result
		List<SpiderResVo> lstSpiderResVo = SpiderUtils.getResult();
		for (SpiderResVo oSpiderResVo : lstSpiderResVo) {
			String strContent = oSpiderResVo.getRes();
			String strQuestion = "";
			String strAnswer = "";

			// 2.1.说明是一篇文章、关于医学科普
			if (strContent.contains("人已访问") && strContent.contains("医学科普")) {
				List<String> lstLines = Arrays.asList(strContent.split("\n"));

				// 2.1.1.疑似"医学科普"
				int iIndexMaybeFindQuestion = -1;
				for (String strLine : lstLines) {
					String strLineTmp = strLine.trim();
					if (strLineTmp.contains("医学科普")) {
						iIndexMaybeFindQuestion = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.2.疑似"医学科普"后第一次出现非""
				int iIndexQuestion = -1;
				for (String strLine : lstLines.subList(iIndexMaybeFindQuestion + 1, lstLines.size())) {
					String strLineTmp = strLine.trim();
					if (!strLineTmp.equals("")) {
						iIndexQuestion = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.3.疑似"人已访问"
				int iIndexMaybeFindAnswer = -1;
				for (String strLine : lstLines.subList(iIndexQuestion + 1, lstLines.size())) {
					String strLineTmp = strLine.trim();
					if (strLineTmp.contains("人已访问")) {
						iIndexMaybeFindAnswer = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.4.疑似"人访问"后第一次出现非""
				int iIndexAnswer = -1;
				for (String strLine : lstLines.subList(iIndexMaybeFindAnswer + 1, lstLines.size())) {
					String strLineTmp = strLine.trim();
					if (!strLineTmp.equals("")) {
						iIndexAnswer = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.5.都找到了，则generate results<SpiderQuesAnsVo>
				if (-1 != iIndexQuestion && -1 != iIndexAnswer) {
					strQuestion = lstLines.get(iIndexQuestion).trim();
					strAnswer = lstLines.get(iIndexAnswer).trim();
					SpiderQuesAnsVo oSpiderQuesAnsVo = new SpiderQuesAnsVo();
					oSpiderQuesAnsVo.setQuestion(strQuestion);
					oSpiderQuesAnsVo.setAnswer(strAnswer);
					lstRes.add(oSpiderQuesAnsVo);
				}
			}
		}

		return lstRes;
	}

	// #endregion
}
