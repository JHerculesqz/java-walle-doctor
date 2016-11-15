package com.huawei._1_model.body_pro;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * 常规问题库<br>
 * @author zhangxincheng
 *
 */
public class BodyProblem {
	
	@Id
	private String id;
	
	// #region Fields
	
	// 检索关键字列表
	private List<String> lstKeyWord;
	
	// 问题答案
	private String answer;
	
	// #endregion
	
	// #region getter/setter

	public List<String> getLstKeyWord() {
		return lstKeyWord;
	}

	public void setLstKeyWord(List<String> lstKeyWord) {
		this.lstKeyWord = lstKeyWord;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	// #endregion
	
	// #region Constructor
	
	public BodyProblem(){
		
	}
	
	// #endregion
	
}

