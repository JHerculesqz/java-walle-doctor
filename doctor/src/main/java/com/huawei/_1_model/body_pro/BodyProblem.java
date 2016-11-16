package com.huawei._1_model.body_pro;

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
	private String keyWord;
	
	// 问题答案
	private String answer;
	
	// #endregion
	
	// #region getter/setter

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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
	
	public BodyProblem(String keyWord, String answer){
		this.keyWord = keyWord;
		this.answer = answer;
	}
	
	// #endregion
	
}

