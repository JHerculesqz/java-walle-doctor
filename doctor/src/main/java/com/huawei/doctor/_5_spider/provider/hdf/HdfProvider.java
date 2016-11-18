package com.huawei.doctor._5_spider.provider.hdf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.huawei._1_fw.spider.SpiderUtils;
import com.huawei._1_fw.spider.vo.SpiderResVo;
import com.huawei.doctor._5_spider.provider.vo.SpiderQuesAnsVo;

public class HdfProvider {
	// #region Const
	
	public static final String KEY_WORD_1 = "���ಡ";
	
	public static final String KEY_WORD_2= "��Ѫѹ";
	
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

			// 2.1.˵����һƪ���¡�����ҽѧ����
			if (strContent.contains("���ѷ���") && strContent.contains("ҽѧ����")) {
				List<String> lstLines = Arrays.asList(strContent.split("\n"));

				// 2.1.1.����"ҽѧ����"
				int iIndexMaybeFindQuestion = -1;
				for (String strLine : lstLines) {
					String strLineTmp = strLine.trim();
					if (strLineTmp.contains("ҽѧ����")) {
						iIndexMaybeFindQuestion = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.2.����"ҽѧ����"���һ�γ��ַ�""
				int iIndexQuestion = -1;
				for (String strLine : lstLines.subList(iIndexMaybeFindQuestion + 1, lstLines.size())) {
					String strLineTmp = strLine.trim();
					if (!strLineTmp.equals("")) {
						iIndexQuestion = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.3.����"���ѷ���"
				int iIndexMaybeFindAnswer = -1;
				for (String strLine : lstLines.subList(iIndexQuestion + 1, lstLines.size())) {
					String strLineTmp = strLine.trim();
					if (strLineTmp.contains("���ѷ���")) {
						iIndexMaybeFindAnswer = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.4.����"�˷���"���һ�γ��ַ�""
				int iIndexAnswer = -1;
				for (String strLine : lstLines.subList(iIndexMaybeFindAnswer + 1, lstLines.size())) {
					String strLineTmp = strLine.trim();
					if (!strLineTmp.equals("")) {
						iIndexAnswer = lstLines.indexOf(strLine);
						break;
					}
				}
				// 2.1.5.���ҵ��ˣ���generate results<SpiderQuesAnsVo>
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
