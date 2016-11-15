package com.huawei._1_model.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.huawei._1_model.healthdata.HeathData;

/**
 * 私人档案库<br>
 * @author zhangxincheng
 *
 */
@Component
public class User {
	
	@Id
	private String id;
	
	// #region Fields

	// 有趣的名字
	private String name;
	
	// 性别
	private String sex;
	
	// 年龄
	private int age;
	
	// 健康数据列表
	private List<HeathData> lstHeathData;
	
	// 疾病列表
	private List<String> lstSickness;
	
	// #endregion
	
	// #region getter/setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<HeathData> getLstHeathData() {
		return lstHeathData;
	}

	public void setLstHeathData(List<HeathData> lstHeathData) {
		this.lstHeathData = lstHeathData;
	}
	
	public void addHeathData(HeathData heathData){
		this.lstHeathData.add(heathData);
	}

	public List<String> getLstSickness() {
		return lstSickness;
	}

	public void setLstSickness(List<String> lstSickness) {
		this.lstSickness = lstSickness;
	}
	
	public void addSickness(String sickness){
		this.lstSickness.add(sickness);
	}
	
	// #endregion
	
	// #region Constructor
	
	public User(){
		
	}
	
	public User(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	// #endregion
	
	// #region toString

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", lstHeathData=" + lstHeathData
				+ ", lstSickness=" + lstSickness + "]";
	}
	
	// #endregion
}
