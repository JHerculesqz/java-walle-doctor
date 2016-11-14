package com.huawei;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.huawei.doctor._4_spider.provider.MainProvider;
import com.huawei.doctor._4_spider.provider.hdf.HdfProvider;
import com.huawei.doctor._4_spider.provider.vo.SpiderQuesAnsVo;

@SpringBootApplication
public class DoctorApplication {

	public static void main(String[] args) {
		List<SpiderQuesAnsVo> lstRes = MainProvider.spiderQuestionAndAnswer(HdfProvider.KEY_WORD_1);
		for (SpiderQuesAnsVo oSpiderQuesAnsVo : lstRes) {
			System.out.println(oSpiderQuesAnsVo.toString());
		}
		// SpringApplication.run(DoctorApplication.class, args);
	}
}
