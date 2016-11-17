package com.huawei._1_model.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import com.huawei._1_model.healthdata.HeathData;

/**
 * ˽�˵�����<br>
 * @author zhangxincheng
 *
 */
@Component
public class User {
	
	@Id
	private String id;
	
	// #region Fields

	// ��Ȥ������
	private String name;
	
	// �Ա�
	private String sex;
	
	// ����
	private String age;
	
	// ���������б�
	private List<HeathData> lstHeathData;
	
	// �����б�
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
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
	
	public User(String name, String sex, String age) {
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
